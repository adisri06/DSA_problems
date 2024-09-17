import java.util.Arrays;
import java.util.Scanner;

public class mergesort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of elements
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Declare the array
        int[] arr = new int[n];

        // Take input from the user
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeArray(arr, 0, arr.length);
        // Print the array to verify input
        System.out.println("The sorted array elements are:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        scanner.close();
    }

    public static void mergeArray(int arr[], int start, int last) {
        System.out.println("merging arrays with " + start + "   " + last);

        if (last - start > 1) {
            int mid = (start + last) / 2;
            mergeArray(arr, start, mid);
            System.out.println("Done with first half");

            mergeArray(arr, mid, last);
            System.out.println("Done with second half");

            merge(arr, start, mid, last);
        }
    }

    public static void merge(int arr[], int start, int mid, int last) {
        System.out.println("Meging smallest possible arrray ----------");

        int[] Left = Arrays.copyOfRange(arr, start, mid);
        int[] Right = Arrays.copyOfRange(arr, mid, last);
        int i = 0, j = 0;

        while (start < last) {
            if (j >= Right.length || (i < Left.length && Left[i] <= Right[j])) {
                System.out.println("Left increment: arr[" + start + "] = " + Left[i]);
                arr[start++] = Left[i++];
            } else {
                System.out.println("Right increment: arr[" + start + "] = " + Right[j]);
                arr[start++] = Right[j++];
            }
        }
    }
}
