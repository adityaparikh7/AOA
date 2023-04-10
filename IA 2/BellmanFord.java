import java.util.*;

// Graph class to represent the weighted graph
class Graph {
    private int V;  // number of vertices
    private int[][] edges;  // adjacency matrix to store the edges and their weights

    public Graph(int V) {
        this.V = V;
        edges = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        }
    }

    // Add an edge to the graph with the given source, destination, and weight
    public void addEdge(int src, int dest, int weight) {
        edges[src][dest] = weight;
    }

    // Bellman-Ford algorithm implementation
    public void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (edges[u][v] != Integer.MAX_VALUE && dist[u] + edges[u][v] < dist[v]) {
                        dist[v] = dist[u] + edges[u][v];
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (edges[u][v] != Integer.MAX_VALUE && dist[u] + edges[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return;
                }
            }
        }

        // Print the shortest distances from the source node
        System.out.println("Shortest distances from the source node:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
}

// Main class to read user input and test the algorithm
public class BellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of vertices in the graph
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();

        // Create a new graph with the given number of vertices
        Graph g = new Graph(V);

        // Read the edges and their weights
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();
        System.out.println("Enter the edges and their weights (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            g.addEdge(src, dest, weight);
        }

        // Read the source node
        System.out.print("Enter the source node: ");
        int srcNode = sc.nextInt();

        // Run the Bellman-Ford algorithm and print the result
        g.bellmanFord(srcNode);
    }
}
