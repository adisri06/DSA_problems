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
        System.out.println("merging arrays with  start :" + start + "  and last : " + last);
        if (last - start > 1) { // Ensure more than one element to merge
            int mid = start + (last - start) / 2;
            System.out.println("Now units are start:  " + start + " mid:   " + mid+ " last:  " +last);
            mergeArray(arr, start, mid);
            System.out.println("Now new units are start:  " + start + " mid:   " + mid+ " last:  " +last);

            mergeArray(arr, mid, last);  // Pass 'last' directly here
            merge(arr, start, mid, last);
        }

    }

    public static void merge(int arr[], int start, int mid, int last) {
        System.out.println("Meging smallest possible arrray ----------");

        int[] newArray = new int[last -start];
        int leftpointer = start, midpointer = mid, x=0 ;

        while(leftpointer< mid && midpointer< last ){
            if(arr[leftpointer]< arr[midpointer]){
                newArray[x++] = arr[leftpointer++];
            }
            else{
                newArray[x++] = arr[midpointer++];

            }

        }
        while(leftpointer< mid)
        {
            newArray[x++] = arr[leftpointer++];
        }
        while(midpointer< last)
        {
            newArray[x++] = arr[midpointer++];
        }
        for (int i = 0; i < newArray.length; i++) {
            arr[start + i] = newArray[i];
        }
    }
}
