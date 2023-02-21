import java.util.*;

public class MergeSort {
   
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
            System.out.print(array[i] + " ");
        }

        System.out.println("\nBefore sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " "); 
        }
        System.out.println();
        long startTime = System.nanoTime();
        mergeSort(array, 0, size - 1);
        long endTime = System.nanoTime();
        System.out.println("After sorting:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        long timeTaken = endTime - startTime;
        System.out.println("\nTime taken: " + timeTaken + " nanoseconds");
    }
}