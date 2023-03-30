import java.util.*;

public class InsertionSort {
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
        insertionSort(arr);
        long endTime = System.currentTimeMillis(); 
        System.out.println("\nSorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken: " + timeTaken + " milliseconds"); 
    }

    public static void insertionSort(int array[]) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }  
    }  
}