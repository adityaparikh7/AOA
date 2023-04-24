import java.util.*;

public class nqueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queens: ");
        int n = sc.nextInt();
        int[] board = new int[n];
        if (solveNQueens(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }

    public static boolean solveNQueens(int[] board, int col) {
        if (col == board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, col, i)) {
                board[col] = i;
                if (solveNQueens(board, col + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int[] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            if (board[i] == row || Math.abs(board[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(int[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j] == i) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}
