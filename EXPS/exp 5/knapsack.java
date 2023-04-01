//implement knapsack problem in java

import java.util.*;

public class knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int w[] = new int[n];
        int p[] = new int[n];
        double ratio[] = new double[n];
        System.out.println("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter the profits of the items: ");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            ratio[i] = (double) p[i] / w[i];
        }
        // sort(w, p, ratio, n);
        sortByMinWeight(w, p, ratio, n);
        sortByMaxRatio(w, p, ratio, n);
        //maximumProfit(w, p, ratio, n, false);
        System.out.println("Enter the capacity of the knapsack: ");
        int c = sc.nextInt();
        int k[][] = ksack(n, c, w, p);
        System.out.println("The maximum profit is " + k[n][c]);
        System.out.println("The items selected are: ");
        int i = n, j = c;
        while (i > 0 && j > 0) {
            if (k[i][j] != k[i - 1][j]) {
                System.out.println("Item " + i);
                j = j - w[i - 1];
            }
            i--;
        }
    }

    public static int[][] ksack(int n, int c, int w[], int p[]) {
        int k[][] = new int[n + 1][c + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0;
                } else if (w[i - 1] <= j) {
                    k[i][j] = Math.max(p[i - 1] + k[i - 1][j - w[i - 1]], k[i - 1][j]);
                } else {
                    k[i][j] = k[i - 1][j];
                }
            }
        }
        return k;
    }

    public static void sortByMinWeight(int w[], int p[], double ratio[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (w[i] > w[j]) {
                    int temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;
                }
            }
        }
        System.out.println("\nItems sorted by minimum weight:");
        for (int i = 0; i < n; i++) {
            System.out.println(
                    "Item " + (i + 1) + ": Weight=" + w[i] + ", Profit=" + p[i] + ", Profit/Weight Ratio=" + ratio[i]);
        }
    }

    public static void sortByMaxRatio(int w[], int p[], double ratio[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ratio[i] < ratio[j]) {
                    int temp = w[i];
                    w[i] = w[j];
                    w[j] = temp;
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                    double tempRatio = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = tempRatio;
                }
            }
        }
        System.out.println("\nItems sorted by maximum profit to weight ratio:");
        for (int i = 0; i < n; i++) {
            System.out.println(
                    "Item " + (i + 1) + ": Weight=" + w[i] + ", Profit=" + p[i] + ", Profit/Weight Ratio=" + ratio[i]);
        }
    }

    // public static int[] maximumProfit(int w[], int p[], double ratio[], int n, boolean sortByMinWeight) {
    //     if (sortByMinWeight) {
    //         sort(w, p, ratio, n, true);
    //     } else {
    //         sort(w, p, ratio, n, false);
    //     }
    //     int k[][] = new int[n+1][c+1];
    //     for(int i=0;i<=n;i++) {
    //         for(int j=0;j<=c;j++) {
    //             if(i==0 || j==0) {
    //                 k[i][j] = 0;
    //             }
    //             else if(w[i-1]<=j) {
    //                 k[i][j] = Math.max(p[i-1]+k[i-1][j-w[i-1]],k[i-1][j]);
    //             }
    //             else {
    //                 k[i][j] = k[i-1][j];
    //             }
    //         }
    //     }
    //     System.out.println("The maximum profit is "+k[n][c]);
    //     System.out.println("The items selected are: ");
    //     int i = n, j = c;
    //     while(i>0 && j>0) {
    //         if(k[i][j]!=k[i-1][j]) {
    //             System.out.println("Item "+i);
    //             j = j-w[i-1];
    //         }
    //         i--;
    //     }
        
    // }

    // public static void sort(int w[], int p[], double ratio[], int n, boolean sortByMinWeight) {
    //     if(sortByMinWeight) {
    //         for(int i=0;i<n-1;i++) {
    //             for(int j=i+1;j<n;j++) {
    //                 if(w[i]>w[j]) {
    //                     int temp = w[i];
    //                     w[i] = w[j];
    //                     w[j] = temp;
    //                     temp = p[i];
    //                     p[i] = p[j];
    //                     p[j] = temp;
    //                     double tempRatio = ratio[i];
    //                     ratio[i] = ratio[j];
    //                     ratio[j] = tempRatio;
    //                 }
    //             }
    //         }
    //         System.out.println("\nItems sorted by minimum weight:");
    //         for(int i=0;i<n;i++) {
    //             System.out.println("Item "+(i+1)+": Weight="+w[i]+", Profit="+p[i]+", Profit/Weight Ratio="+ratio[i]);
    //         }
    //     }
    //     else {
    //         for(int i=0;i<n-1;i++) {
    //             for(int j=i+1;j<n;j++) {
    //                 if(ratio[i]<ratio[j]) {
    //                     int temp = w[i];
    //                     w[i] = w[j];
    //                     w[j] = temp;
    //                     temp = p[i];
    //                     p[i] = p[j];
    //                     p[j] = temp;
    //                     double tempRatio = ratio[i];
    //                     ratio[i] = ratio[j];
    //                     ratio[j] = tempRatio;
    //                 }
    //             }
    //         }
    //         System.out.println("\nItems sorted by maximum profit to weight ratio:");
    //         for(int i=0;i<n;i++) {
    //             System.out.println("Item "+(i+1)+": Weight="+w[i]+", Profit="+p[i]+", Profit/Weight Ratio="+ratio[i]);
    //         }
    //     }
    // }
}
