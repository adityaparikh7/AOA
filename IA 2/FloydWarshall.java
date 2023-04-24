// public class FloydWarshall {
//     public static void shortestPaths(int[][] graph) {
//         int n = graph.length;
        
//         // initialize distances with direct edge weights
//         int[][] dist = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 dist[i][j] = graph[i][j];
//             }
//         }
        
//         // calculate shortest paths using Floyd-Warshall algorithm
//         for (int k = 0; k < n; k++) {
//             for (int i = 0; i < n; i++) {
//                 for (int j = 0; j < n; j++) {
//                     if (dist[i][j] > dist[i][k] + dist[k][j]) {
//                         dist[i][j] = dist[i][k] + dist[k][j];
//                     }
//                 }
//             }
//         }
        
//         // print shortest path distances
//         System.out.println("Shortest path distances:");
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 System.out.print(dist[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void main(String[] args) {
//         int[][] graph = {
//             {0, 5, 999, 10},
//             {999, 0, 3, 999},
//             {999, 999, 0, 1},
//             {999, 999, 999, 0}
//         };
//         shortestPaths(graph);
//     }
// }

//random input

import java.util.*;

public class FloydWarshall {
    public static void shortestPaths(int[][] graph) {
        int n = graph.length;
        
        // initialize distances with direct edge weights
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        
        // calculate shortest paths using Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // print shortest path distances
        System.out.println("Shortest path distances:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: "); // number of nodes in graph
        int n = sc.nextInt();
         
        int[][] graph = new int[n][n];
        Random random = new Random();
        
        // initialize graph with random edge weights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = random.nextInt(10);
                }
            }
        }
        
        // print graph before sorting
        System.out.println("Graph before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
        
        // calculate shortest paths
        shortestPaths(graph);
    }
}

