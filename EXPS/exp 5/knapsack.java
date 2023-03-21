//implement knapsack problem in java
// import java.util.*;

// public class knapsack
// {
//     public static void main(String args[])
//     {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of items");
//         int n = sc.nextInt();
//         int w[] = new int[n];
//         int p[] = new int[n];
//         System.out.println("Enter the weights of the items");
//         for(int i=0;i<n;i++)
//         {
//             w[i] = sc.nextInt();
//         }
//         System.out.println("Enter the profits of the items");
//         for(int i=0;i<n;i++)
//         {
//             p[i] = sc.nextInt();
//         }
//         System.out.println("Enter the capacity of the knapsack");
//         int c = sc.nextInt();
//         int k[][] = new int[n+1][c+1];
//         for(int i=0;i<=n;i++)
//         {
//             for(int j=0;j<=c;j++)
//             {
//                 if(i==0 || j==0)
//                 {
//                     k[i][j] = 0;
//                 }
//                 else if(w[i-1]<=j)
//                 {
//                     k[i][j] = Math.max(p[i-1]+k[i-1][j-w[i-1]],k[i-1][j]);
//                 }
//                 else
//                 {
//                     k[i][j] = k[i-1][j];
//                 }
//             }
//         }
//         System.out.println("The maximum profit is "+k[n][c]);
//         System.out.println("The items selected are");
//         int i=n,j=c;
//         while(i>0 && j>0)
//         {
//             if(k[i][j]!=k[i-1][j])
//             {
//                 System.out.println("Item "+i);
//                 j = j-w[i-1];
//             }
//             i--;
//         }
//     }
// }

// public class knapsack
// {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of items: ");
//         int n = sc.nextInt();
//         int w[] = new int[n];
//         int p[] = new int[n];
//         System.out.println("Enter the weights of the items: ");
//         for(int i=0;i<n;i++)
//         {
//             w[i] = sc.nextInt();
//         }
//         System.out.println("Enter the profits of the items: ");
//         for(int i=0;i<n;i++)
//         {
//             p[i] = sc.nextInt();
//         }
//         System.out.println("Enter the capacity of the knapsack: ");
//         int c = sc.nextInt();
//         knpsck();
//         System.out.println("The maximum profit is "+k[n][c]);
//         System.out.println("The items selected are: ");
//         int i=n,j=c;
//         while(i>0 && j>0)
//         {
//             if(k[i][j]!=k[i-1][j])
//             {
//                 System.out.println("Item "+i);
//                 j = j-w[i-1];
//             }
//             i--;
//         }
//     }

//     public static void knpsck(int n, int c, int w, int p)
//     {
//         int k[][] = new int[n+1][c+1];
//         for(int i=0;i<=n;i++)
//         {
//             for(int j=0;j<=c;j++)
//             {
//                 if(i==0 || j==0)
//                 {
//                     k[i][j] = 0;
//                 }
//                 else if(w[i-1]<=j)
//                 {
//                     k[i][j] = Math.max(p[i-1]+k[i-1][j-w[i-1]],k[i-1][j]);
//                 }
//                 else
//                 {
//                     k[i][j] = k[i-1][j];
//                 }
//             }
//         }
//     }
// }

import java.util.*;

public class knapsack {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int n = sc.nextInt();
        int w[] = new int[n];
        int p[] = new int[n];
        System.out.println("Enter the weights of the items: ");
        for(int i=0;i<n;i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter the profits of the items: ");
        for(int i=0;i<n;i++) {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter the capacity of the knapsack: ");
        int c = sc.nextInt();
        int k[][] = ksack(n, c, w, p);
        System.out.println("The maximum profit is "+k[n][c]);
        System.out.println("The items selected are: ");
        int i=n,j=c;
        while(i>0 && j>0) {
            if(k[i][j]!=k[i-1][j]) {
                System.out.println("Item "+i);
                j = j-w[i-1];
            }
            i--;
        }
    }

    public static int[][] ksack(int n, int c, int w[], int p[]) {
        int k[][] = new int[n+1][c+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=c;j++) {
                if(i==0 || j==0) {
                    k[i][j] = 0;
                }
                else if(w[i-1]<=j) {
                    k[i][j] = Math.max(p[i-1]+k[i-1][j-w[i-1]],k[i-1][j]);
                }
                else {
                    k[i][j] = k[i-1][j];
                }
            }
        }
        return k;
    }
}
