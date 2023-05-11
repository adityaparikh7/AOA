package Practice;
import java.util.*;

public class TSP {

    private int[][] distances;
    private int numCities;

    public TSP(int[][] distances) {
        this.distances = distances;
        this.numCities = distances.length;
    }

    public int solve() {
        ArrayList<Integer> cities = new ArrayList<Integer>();
        for (int i = 1; i < numCities; i++) {
            cities.add(i);
        }
        return permute(cities, 0);
    }

    private int permute(ArrayList<Integer> cities, int startIndex) {
        if (startIndex == cities.size() - 1) {
            return calculatePath(cities);
        } else {
            int minDistance = Integer.MAX_VALUE;
            for (int i = startIndex; i < cities.size(); i++) {
                Collections.swap(cities, startIndex, i);
                int distance = permute(cities, startIndex + 1);
                minDistance = Math.min(minDistance, distance);
                Collections.swap(cities, startIndex, i);
            }
            return minDistance;
        }
    }

    private int calculatePath(ArrayList<Integer> cities) {
        int distance = distances[0][cities.get(0)];
        for (int i = 0; i < cities.size() - 1; i++) {
            distance += distances[cities.get(i)][cities.get(i+1)];
        }
        distance += distances[cities.get(cities.size()-1)][0];
        return distance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int n = input.nextInt();
        int[][] distances = new int[n][n];
        System.out.println("Enter the distances between the cities:");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the distances from city " + (i+1) + " to all other cities:");
            for (int j = 0; j < n; j++) {
                distances[i][j] = input.nextInt();
            }
        }
        TSP tsp = new TSP(distances);
        long startTime = System.currentTimeMillis(); 
        int distance = tsp.solve();
        long endTime = System.currentTimeMillis(); 
        System.out.println("Minimum distance: " + distance);
        long timeTaken = endTime - startTime;
        System.out.println("Time taken: " + timeTaken + " milliseconds"); 
    }
}
