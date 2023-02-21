import java.util.Scanner;

public class Merge2Arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.print("Enter the elements of the first array: ");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.print("Enter the elements of the second array: ");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result = mergeArrays(arr1, arr2);

        System.out.println("After merging the two arrays:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] result = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
}