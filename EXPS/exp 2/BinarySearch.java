//binary search using insertion sort

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to be searched: ");
        int search = sc.nextInt();
        long startTime = System.nanoTime(); 
        insertionSort(arr);
        long endTime = System.nanoTime(); 
      
        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        int result = binarySearch(arr, 0, n - 1, search);
        if (result == -1) {
            System.out.println("\nElement not found");
        } else {
            System.out.println("\nElement found at index " + result);
        }
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken: " + timeTaken + " nanoseconds");
    }


    //recursive method
    // public static int binarySearch(int arr[], int low, int high, int x){
    //     if (high >= low) {
    //         int mid = (low + high) / 2;
    //         if (arr[mid] == x) {
    //             return mid;
    //         }
    //         if (arr[mid] > x) {
    //             return binarySearch(arr, low, mid - 1, x);
    //         }
    //         return binarySearch(arr, mid + 1, high, x);
    //     }
    //     return -1;
    // }

    //iterative method
    public static int binarySearch(int arr[], int low, int high, int x){
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}