public class GeoFloydWarshall {
    public static final int RADIUS_EARTH = 6371; // radius of the Earth in kilometers

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIUS_EARTH * c;
    }

    public static void shortestPaths(double[][] graph) {
        int n = graph.length;
        
        // initialize distances with direct edge weights
        double[][] dist = new double[n][n];
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
        double[][] graph = {
            {0, haversine(52.520008, 13.404954, 48.856613, 2.352222), haversine(52.520008, 13.404954, 51.507351, -0.127758)},
            {haversine(52.520008, 13.404954, 48.856613, 2.352222), 0, haversine(48.856613, 2.352222, 51.507351, -0.127758)},
            {haversine(52.520008, 13.404954, 51.507351, -0.127758), haversine(48.856613, 2.352222, 51.507351, -0.127758), 0}
        };
        shortestPaths(graph);
    }
}
