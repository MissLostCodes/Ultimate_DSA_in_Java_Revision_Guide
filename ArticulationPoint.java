import java.util.*;

public class ArticulationPoint {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Add edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int parent,
                           int[] dt, int[] low, int[] time, boolean[] vis, boolean[] isAp) {
        vis[curr] = true;
        dt[curr] = low[curr] = time[0]++;
        int children = 0;

        for (Edge edge : graph[curr]) {
            int neigh = edge.dest;

            if (neigh == parent) {
                continue;
            }

            if (!vis[neigh]) {
                dfs(graph, neigh, curr, dt, low, time, vis, isAp);
                low[curr] = Math.min(low[curr], low[neigh]);

                // Check for articulation point
                if (parent != -1 && dt[curr] <= low[neigh]) {
                    isAp[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[neigh]);
            }
        }

        // Check root articulation point
        if (parent == -1 && children > 1) {
            isAp[curr] = true;
        }
    }

    public static void getAp(ArrayList<Edge>[] graph, int V) {
        int[] dt = new int[V];
        int[] low = new int[V];
        int[] time = {0};
        boolean[] vis = new boolean[V];
        boolean[] isAp = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, time, vis, isAp);
            }
        }

        System.out.println("Articulation Points:");
        for (int i = 0; i < V; i++) {
            if (isAp[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        getAp(graph, V);
    }
}
