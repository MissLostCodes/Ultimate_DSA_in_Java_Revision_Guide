import java.util.* ;

public class bfs {
 static class Edge{
	 int src ;
	 int dest ;
	 int wt ;
	 
	 public Edge(int s , int d , int w ) {
		 this.src = s ;
		 this.dest = d ;
		 this.wt = w; 
	 }
public static void  bfs_traversal(ArrayList<Edge> graph[]) {
	boolean visited[] = new boolean[graph.length] ;
	Queue<Integer> q = new LinkedList<>();
	
	q.add(0); // main source initialized in queue 
	
	while(!q.isEmpty()) {
		int curr = q.remove();
		if(visited[curr] == false ) {
			System.out.print(curr + " ");
			visited[curr] = true ;
			
			for(int i  = 0 ; i < graph[curr].size() ; i++) {
				q.add(graph[curr].get(i).dest);
			}
		}
	}
	
	
	
}
public static void dfs(ArrayList<Edge>[] graph , int curr  , boolean[] visited) {
	
	visited[curr] = true ;
	System.out.print(curr + " ");
	for(int i  = 0 ; i  <graph[curr].size(); i++) {
		Edge e = graph[curr].get(i);
		if(visited[e.dest]==false) {
			dfs(graph , e.dest , visited );
		}
	}
}
 public static void createGraph(ArrayList<Edge> graph[]) {
	 for(int i = 0 ; i<graph.length ; i++) {
		 graph[i] = new ArrayList<>();
	 }
	 
	 graph[0].add(new Edge(0,1,1));
	 graph[0].add(new Edge(0,2,1));
	 
	 graph[1].add(new Edge(1,3,1));
	 graph[1].add(new Edge(1,0,1));
	 
	 graph[2].add(new Edge(2,3,1));
	 graph[2].add(new Edge(2,0,1));
	 
	 graph[3].add(new Edge(3,5,1));
	 graph[3].add(new Edge(3,0,1));
	 
	 graph[4].add(new Edge(4,5,1));
	 graph[4].add(new Edge(4,0,1));
	 
	 graph[5].add(new Edge(5,6,1));
	 graph[5].add(new Edge(5,3,1));
	 graph[5].add(new Edge(5,6,1));
	 
	 graph[6].add(new Edge(6,5,1));
	 graph[6].add(new Edge(6,4,1));
	 
 }
 public static boolean hasPath(ArrayList<Edge>[] graph , int src , int dest , boolean[] visited ) {
	 // base case
	 if(src == dest ) {
		 return true ;
	 }
	 visited[src]= true ;
	 for (int i  = 0 ; i < graph[src].size() ; i++ ) {
		 Edge e = graph[src].get(i);
	 if (!visited[e.dest] && hasPath(graph , e.dest , dest , visited  ) ) {
		 return true ;
	 }}
	 return false ;
 }
 public static void main (String args[]) {
	 ArrayList<Edge> graph[] = new ArrayList[7];
	 createGraph(graph);
	 
	 bfs_traversal(graph);
	 int v = 7 ;
	 System.out.println("----dfs----->");
	 dfs(graph , 0 , new boolean[v]);
 }
 }
}
