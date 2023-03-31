import java.util.*;

public class MinMaxStr {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements: ");
    int n = sc.nextInt();

    int[] array = new int[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      array[i] = random.nextInt(10000);
      System.out.print(array[i] + " ");
    }

    int min = array[0];
    int max = array[0];

    long startTime = System.nanoTime();
    for (int i = 1; i < n; i++) {
      if (array[i] < min) {
        min = array[i];
      }
      if (array[i] > max) {
        max = array[i];
      }
    }
    long endTime = System.nanoTime();
    long timeTaken = endTime - startTime;

    System.out.println("\nMin: " + min);
    System.out.println("Max: " + max);
    System.out.println("Time taken: " + timeTaken + " nanoseconds");
  }
}