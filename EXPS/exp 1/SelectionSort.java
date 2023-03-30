import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //random input
        Random rand = new Random();
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000000);
            System.out.print(arr[i] + " ");
        }

        long startTime = System.currentTimeMillis(); 
        selectionSort(arr);
        long endTime = System.currentTimeMillis(); 
        System.out.println("\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken: " + timeTaken + " milliseconds");
        
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}