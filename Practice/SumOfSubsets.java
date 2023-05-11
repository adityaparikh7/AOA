package Practice;
import java.util.*;

public class SumOfSubsets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input set
        System.out.print("Enter the size of the input set: ");
        int n = scanner.nextInt();
        int[] set = new int[n];
        System.out.println("Enter the elements of the input set:");
        for (int i = 0; i < n; i++) {
            set[i] = scanner.nextInt();
        }

        // Get target sum
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // Base case: empty set has sum 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Dynamic programming: fill in the table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j]; // exclude the current element
                if (j >= set[i - 1]) { // check if the current element can be included
                    dp[i][j] |= dp[i - 1][j - set[i - 1]];
                }
            }
        }

        // Backtrack to find the solution
        if (dp[n][sum]) {
            System.out.println("Solution exists.");
            int i = n, j = sum;
            while (i > 0 && j > 0) {
                if (dp[i - 1][j]) { // current element was excluded
                    i--;
                } else { // current element was included
                    System.out.print(set[i - 1] + " ");
                    j -= set[i - 1];
                    i--;
                }
            }
        } else {
            System.out.println("No solution exists.");
        }

        scanner.close();
    }
}