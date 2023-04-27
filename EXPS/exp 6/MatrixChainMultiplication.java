import java.util.*;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of matrices: ");
        int n = sc.nextInt();
        int[] dimensions = new int[n+1];
        System.out.println("Enter dimensions of matrices: ");
        for(int i=0; i<=n; i++){
            dimensions[i] = sc.nextInt();
        }
        int[][] m = new int[n+1][n+1];
        int[][] s = new int[n+1][n+1];
        matrixChainOrder(dimensions, m, s);
        System.out.println("Minimum number of multiplications: "+m[1][n]);
        System.out.println("Optimal parenthesization: ");
        printOptimalParenthesization(s, n, n);
    }

    public static void matrixChainOrder(int[] dimensions, int[][]m, int[][]s) {
        int n = dimensions.length-1;
        for(int i=1; i<=n; i++){
            m[i][i] = 0;
        }
        for(int l=2; l<=n; l++){
            for(int i=1; i<=n-l+1; i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++){
                    int q = m[i][k] + m[k+1][j] + dimensions[i-1]*dimensions[k]*dimensions[j];
                    if(q<m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public static void printOptimalParenthesization(int[][] s, int i, int j){
        if(i==j){
            System.out.print("A"+i);
        }
        else{
            System.out.print("(");
            printOptimalParenthesization(s, i, s[i][j]);
            printOptimalParenthesization(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }
}
