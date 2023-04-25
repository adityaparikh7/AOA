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

// import java.util.*;

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
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter number of nodes: "); // number of nodes in graph
//         int n = sc.nextInt();

//         int[][] graph = new int[n][n];
//         Random random = new Random();

//         // initialize graph with random edge weights
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == j) {
//                     graph[i][j] = 0;
//                 } else {
//                     graph[i][j] = random.nextInt(10);
//                 }
//             }
//         }

//         // print graph before sorting
//         System.out.println("Graph before sorting:");
//         for (int i = 0; i < n; i++) {
//             System.out.println(Arrays.toString(graph[i]));
//         }

//         // calculate shortest paths
//         shortestPaths(graph);
//     }
// }

//using co-ordinates

import java.util.*;

public class FloydWarshall {
    private static final int NUM_CITIES = 10;

    private static final Map<String, double[]> CITY_COORDS = new HashMap<String, double[]>() {
        {
            put("New York", new double[] { 40.7128, -74.0060 });
            put("Los Angeles", new double[] { 34.0522, -118.2437 });
            put("Chicago", new double[] { 41.8781, -87.6298 });
            put("Houston", new double[] { 29.7604, -95.3698 });
            put("Phoenix", new double[] { 33.4484, -112.0740 });
            put("Philadelphia", new double[] { 39.9526, -75.1652 });
            put("San Antonio", new double[] { 29.4241, -98.4936 });
            put("San Diego", new double[] { 32.7157, -117.1611 });
            put("Dallas", new double[] { 32.7767, -96.7970 });
            put("San Jose", new double[] { 37.3382, -121.8863 });
            put("Atlanta", new double[] { 33.7490, -84.3880});
            put("Detroit", new double[] { 42.3314, -83.0458 });
            put("Jacksonville", new double[] { 30.3322, -81.6557 });
            put("Indianapolis", new double[] { 39.7684, -86.1581 });
            put("San Francisco", new double[] { 37.7749, -122.4194 });
            put("Columbus", new double[] { 39.9612, -82.9988 });
            put("Austin", new double[] { 30.2672, -97.7431 });
            put("Memphis", new double[] { 35.1495, -90.0489 });
            put("Baltimore", new double[] { 39.2904, -76.6122 });
            put("Charlotte", new double[] { 35.2271, -80.8431 });
            put("Fort Worth", new double[] { 32.7555, -97.3308 });
            put("Milwaukee", new double[] { 43.0389, -87.9065 });
            put("Boston", new double[] { 42.3601, -71.0589 });
            put("El Paso", new double[] { 31.7776, -106.4424 });
            put("Seattle", new double[] { 47.6062, -122.3321 });
            put("Denver", new double[] { 39.7392, -104.9903 });
            put("Washington", new double[] { 38.9072, -77.0369 });
            put("Nashville", new double[] { 36.1627, -86.7816 });
            put("Portland", new double[] { 45.5231, -122.6765 });
            put("Oklahoma City", new double[] { 35.4676, -97.5137 });
            put("Las Vegas", new double[] { 36.1699, -115.1398 });
            put("Louisville", new double[] { 38.2527, -85.7585 });
            put("Birmingham", new double[] { 33.5207, -86.8025 });
            put("Tucson", new double[] { 32.2217, -110.9265 });
            put("Fresno", new double[] { 36.7477, -119.7726 });
            put("Sacramento", new double[] { 38.5816, -121.4944 });
            put("Long Beach", new double[] { 33.8042, -118.1675 });
            put("Kansas City", new double[] { 39.0997, -94.5786 });
            put("Mesa", new double[] { 33.4152, -111.8315 });
            put("Virginia Beach", new double[] { 36.8529, -75.9780 });
            put("Colorado Springs", new double[] { 38.8339, -104.8214 });
            put("Raleigh", new double[] { 35.7721, -78.6386 });
        }
    };

    private static final double EARTH_RADIUS = 6371.0; // Earth's radius in kilometers

    public static void main(String[] args) {
        double[][] distances = calculateDistances();
        printDistances(distances, NUM_CITIES);
        long startTime = System.currentTimeMillis(); 
        findShortestPath(distances, 0, 4);
        long endTime = System.currentTimeMillis(); 
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken: " + timeTaken + " milliseconds");

    }

    private static double[][] calculateDistances() {
        double[][] distances = new double[NUM_CITIES][NUM_CITIES];
        for (int i = 0; i < NUM_CITIES; i++) {
            for (int j = 0; j < NUM_CITIES; j++) {
                if (i == j) {
                    distances[i][j] = 0.0;
                } else {
                    double[] coords1 = CITY_COORDS.get(getCityName(i));
                    double[] coords2 = CITY_COORDS.get(getCityName(j));
                    distances[i][j] = haversine(coords1[0], coords1[1], coords2[0], coords2[1]);
                }
            }
        }
        return distances;
    }

    private static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }

    private static void printDistances(double[][] distances, int numCities) {
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                System.out.printf("%-15s to %-15s: %.2f km\n", getCityName(i), getCityName(j), distances[i][j]);
            }
        }
    }

    private static String getCityName(int index) {
        return CITY_COORDS.keySet().toArray(new String[0])[index];
    }
    // public static void findShortestPath(double[][] distances, int sourceCity, int
    // targetCity)
    // {
    // int numCities = distances.length;
    // int[][] shortestDistances = new int[numCities][numCities];
    // int[][] nextCities = new int[numCities][numCities];
    // for (int i = 0; i < numCities; i++) {
    // for (int j = 0; j < numCities; j++) {
    // shortestDistances[i][j] = (int) distances[i][j];
    // if (i != j && distances[i][j] < Integer.MAX_VALUE)
    // {
    // nextCities[i][j] = j;
    // }
    // }
    // }
    // for (int k = 0; k < numCities; k++) {
    // for (int i = 0; i < numCities; i++) {
    // for (int j = 0; j < numCities; j++) {
    // if (shortestDistances[i][k] < Integer.MAX_VALUE &&
    // shortestDistances[k][j] < Integer.MAX_VALUE &&
    // shortestDistances[i][k] + shortestDistances[k][j] < shortestDistances[i][j])
    // {
    // shortestDistances[i][j] = shortestDistances[i][k] + shortestDistances[k][j];
    // nextCities[i][j] = nextCities[i][k];
    // }
    // }
    // }
    // }
    // if (shortestDistances[sourceCity][targetCity] < Integer.MAX_VALUE) {
    // System.out.printf("Shortest distance between city"+getCityName(sourceCity)+
    // "and city"+getCityName(targetCity)+ "is"
    // +shortestDistances[sourceCity][targetCity]);
    // List<Integer> path = new ArrayList<>();
    // int currentCity = sourceCity;
    // while (currentCity != targetCity) {
    // path.add(currentCity);
    // currentCity = nextCities[currentCity][targetCity];
    // }
    // path.add(targetCity);
    // System.out.print("Shortest path: ");
    // for (int i = 0; i < path.size(); i++) {
    // System.out.print(path.get(i));
    // if (i < path.size() - 1) {
    // System.out.print(" -> ");
    // }
    // }
    // } else {
    // System.out.printf("There is no path from city %d to city %d\n", sourceCity,
    // targetCity);
    // }
    // }

    public static void findShortestPath(double[][] distances, int sourceCity, int targetCity) {
        int numCities = distances.length;
        int[][] shortestDistances = new int[numCities][numCities];
        int[][] nextCities = new int[numCities][numCities];
        for (int i = 0; i < numCities; i++) {
            for (int j = 0; j < numCities; j++) {
                shortestDistances[i][j] = (int) distances[i][j];
                if (i != j && distances[i][j] < Integer.MAX_VALUE) {
                    nextCities[i][j] = j;
                }
            }
        }
        for (int k = 0; k < numCities; k++) {
            for (int i = 0; i < numCities; i++) {
                for (int j = 0; j < numCities; j++) {
                    if (shortestDistances[i][k] < Integer.MAX_VALUE &&
                            shortestDistances[k][j] < Integer.MAX_VALUE &&
                            shortestDistances[i][k] + shortestDistances[k][j] < shortestDistances[i][j]) {
                        shortestDistances[i][j] = shortestDistances[i][k] + shortestDistances[k][j];
                        nextCities[i][j] = nextCities[i][k];
                    }
                }
            }
        }
        if (shortestDistances[sourceCity][targetCity] < Integer.MAX_VALUE) {
            System.out.printf("Shortest distance between %s and %s is %d km.\n", getCityName(sourceCity),
                    getCityName(targetCity), shortestDistances[sourceCity][targetCity]);
            List<Integer> path = new ArrayList<>();
            int currentCity = sourceCity;
            while (currentCity != targetCity) {
                path.add(currentCity);
                currentCity = nextCities[currentCity][targetCity];
            }
            path.add(targetCity);
            System.out.print("Shortest path: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(getCityName(path.get(i)));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        } else {
            System.out.printf("No path found between %s and %s.\n", getCityName(sourceCity), getCityName(targetCity));
        }
    }

}