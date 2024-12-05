package DSA;

public class mergesort {
    public static GenerateArray genz = new GenerateArray(6);

    public int[] mergeSorting(int[] arr, int start, int end) {
        if (start < end) {

            int mid = start + (end - start) / 2;
            System.out.println("\nInside Merge Sorting:" + start + " " + end + " " + mid);

            arr = mergeSorting(arr, start, mid);
            arr = mergeSorting(arr, mid + 1, end);
            arr = merge(arr, start, mid, end);
        }
        return arr;
    }

    public int[] merge(int[] arr, int start, int mid, int end) {
        System.out.println("\nInside Merge:" + start + " " + end + " " + mid);
        int left = mid - start + 1;
        int right = end - mid;
        int leftArray[] = new int[left];
        int rightArray[] = new int[right];
        for (int i = 0; i < left; i++) {
            leftArray[i] = arr[start + i];
        }
        for (int i = 0; i < right; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }
        int i = 0;
        int j = 0;
        int k = start;
        while (i < left && j < right) {
            if (leftArray[i] < rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (i < left) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < right) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        return arr;

    }

    public static void main(String[] args) {

        int arr[] = genz.generate();
        System.out.println("Generated Array is :");
        genz.print(arr);
        mergesort obj = new mergesort();
        int start = 0;
        int end = arr.length - 1;
        arr = obj.mergeSorting(arr, start, end);
        System.out.println("Sorted Array is :");

        genz.print(arr);

    }

}