import java.util.*;

public class FloydWarshall2 {
    public static void print(int a[][], String[] cities) {
        System.out.println(" ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    System.out
                            .println("Distance between " + cities[i] + " and " + cities[j] + " is " + a[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static int[][] floydwarshall(int[][] graph){
        int n = graph.length;
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = graph[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
        return D;
    }
    public static void main(String[] args) {
        String cities[] = { "Mumbai", "Surat", "Goa", "Delhi", "Kolkata", "Chennai"};
        int n = cities.length;
        int[][] graph = new int[n][n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = random.nextInt(1000);
                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }
        System.out.println("");
        System.out.println("Distance matrix:");
        for (int i = -1; i < n; i++) {
            if (i == -1) {
                System.out.print(" \t");
            } else {

                System.out.print(cities[i] + "\t");
            }
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = -1; j < n; j++) {
                if (j == -1) {
                    System.out.print(cities[i] + "\t");
                } else {
                    System.out.print(graph[i][j] + "\t");
                }
            }
            System.out.println("");
        }

        long startTime = System.nanoTime();
        graph = floydwarshall(graph);
        long endTime = System.nanoTime();
        print(graph, cities);
        System.out.println(" ");
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
    }
}