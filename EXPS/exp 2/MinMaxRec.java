import java.util.*;

public class MinMaxRec {

  static int min;
  static int max;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of the array: ");
    int size = sc.nextInt();
    int[] arr = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      arr[i] = random.nextInt(10000);
      System.out.print(arr[i] + " ");
    }

    long startTime = System.nanoTime();
    minMaxRecursive(arr, 0, size - 1);
    long endTime = System.nanoTime();
    long timeTaken = endTime - startTime;

    System.out.println("\nMin: " + min);
    System.out.println("Max: " + max);
    System.out.println("Time taken: " + timeTaken + " nanoseconds");
  }

  public static void minMaxRecursive(int[] arr, int start, int end) {
    if (start == end) {
      min = arr[start];
      max = arr[start];
    } else if (start == end - 1) {
      if (arr[start] > arr[end]) {
        min = arr[end];
        max = arr[start];
      } else {
        min = arr[start];
        max = arr[end];
      }
    } else {
      int mid = (start + end) / 2;

      minMaxRecursive(arr, start, mid);
      minMaxRecursive(arr, mid + 1, end);
      min = Math.min(min, min);
      max = Math.max(max, max);

    }
  }
}