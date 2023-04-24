import java.util.*;

public class FloydWarshallMap{

    public static final int INF = 999999; // Infinity value for unreachable vertices

    public static void main(String[] args) {
        String[] cities = {"New York", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "San Francisco", "Charlotte", "Indianapolis", "Seattle", "Denver", "Boston"};
        int[][] graph = generateGraph(cities.length);
        long startTime = System.currentTimeMillis();
        int[][] shortestPaths = floydWarshall(graph);
        long endTime = System.currentTimeMillis();
        System.out.printf("Time complexity: O(n^3), where n=%d\n", graph.length);
        System.out.printf("Execution time: %dms\n", endTime - startTime);
        System.out.printf("Space complexity: O(n^2), where n=%d\n", graph.length);
        printShortestPaths(cities, shortestPaths);
    }

    public static int[][] generateGraph(int n) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = (int) (Math.random() * 5000) + 1; // Random distance in km between 1 and 5000
                }
            }
        }
        return graph;
    }

    public static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] distances = new int[n][n];

        // Initialize the distances matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = graph[i][j];
            }
        }

        // Calculate the shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        return distances;
    }

    public static void printShortestPaths(String[] cities, int[][] shortestPaths) {
        System.out.println("Shortest paths between all pairs of cities:");
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                if (i != j) {
                    System.out.printf("%s to %s: %dkm\n", cities[i], cities[j], shortestPaths[i][j]);
                }
            }
        }
    }
}