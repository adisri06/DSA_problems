package DSA;

import java.util.Random;

public class SelectionSort {
    public void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public int[] selectionSort(int[] arr) {
        int length = arr.length;
        int min;
        for (int i =0;i< arr.length ;i++){
            min = arr[i];
            for (int j =i +1;j< length;j++){
                // if arr[j] > min Descending order sorting
                // if arr[j] < min Ascending order sorting
                if(arr[j] > min){
                    min = arr[j];
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;

    }
    public static void main(String[] args) {
        Random random = new Random();
        int arr[] = new int[10];
        for (int i =0; i< 10 ;i++){
            arr[i]= random.nextInt(100);
        }

        SelectionSort obj = new SelectionSort();
        obj.print(arr);
        arr = obj.selectionSort(arr);
        System.out.println("\nSorted array:");
        obj.print(arr);
    }

}
