import java.util.* ;

public class BFS_CYCLE_DETECT {
static class Edge{
	int src ;
	int dest ;
	Edge(int s , int d ){
		this.src = s ;
		this.dest=d ;
	}
}

public static boolean detect_cycle(ArrayList<Edge>[] graph  ) {
	Queue<Integer> q = new LinkedList<>();
	int parent[] = new int[graph.length];
	for(int i  =0 ; i  <graph.length ;i++ ) {
		parent[i]=-1;
	}
	boolean visited[] = new boolean[graph.length];
	 for (int i = 0; i < graph.length; i++) {
         if (!visited[i]) {  // If the node is not visited, start BFS
             visited[i] = true;
                q.add(i);
	while(!q.isEmpty()) {
		int curr = q.remove();
		for(int j =0 ;j < graph[curr].size() ; j++) {
			Edge e = graph[curr].get(j);
			
			if(!visited[e.dest]) {
				parent[e.dest]=curr;
				 visited[e.dest] = true;
				 q.add(e.dest);
			}
			 else if (parent[curr] != e.dest) {
                 return true;  // Cycle found
             }
		}}
		}
	}
	return false;
	
}
public static void main(String args[]) {
	int v = 5 ;
	ArrayList<Edge>[] graph = new ArrayList[5];
	 for (int i = 0; i < v; i++) {
         graph[i] = new ArrayList<>();
     }
	graph[0].add(new Edge(0,1));
	graph[0].add(new Edge(0,2));
	//graph[0].add(new Edge(0,3));
	
	graph[1].add(new Edge(1,3));
	graph[1].add(new Edge(1,0));
	
	graph[2].add(new Edge(2,4));
	graph[2].add(new Edge(2,0));
	
	graph[3].add(new Edge(3,1));
	//graph[3].add(new Edge(3,0));
	
	graph[4].add(new Edge(4,2));
	 if (detect_cycle(graph)) {
         System.out.println("Cycle detected");
     } else {
         System.out.println("No cycle detected");
     }
	
}
}
