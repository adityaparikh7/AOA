import java.util.*;

public class ShortestPath {
    
    private static int N;  // number of vertices
    private static List<List<Node>> adj;  // adjacency list of nodes
    private static int[] dist;  // distances from source
    private static boolean[] visited;  // visited nodes
    
    //class to represent a vertex and its weight
    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;
        
        public Node(int v, int w) {
            vertex = v;
            weight = w;
        }
        
        public int compareTo(Node other) {
            return weight - other.weight;
        }
    }
    
    // Method to add an edge to the graph
    private static void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));
    }
    
    // Method to initialize the graph
    private static void initialize(int n) {
        N = n;
        adj = new ArrayList<>();
        dist = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
    }
    
    // Method to find the shortest path from a source vertex
    private static void dijkstra(int source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[source] = 0;
        pq.add(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int w = neighbor.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        initialize(n);
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();
        System.out.println("Enter the edges (source, destination, weight):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(u, v, w);
        }
        System.out.print("Enter the source vertex: ");
        int source = scanner.nextInt();
        dijkstra(source);
        System.out.println("Shortest distances from the source vertex:");
        for (int i = 0; i < N; i++) {
            System.out.println(i + ": " + dist[i]);
        }
    }
}
