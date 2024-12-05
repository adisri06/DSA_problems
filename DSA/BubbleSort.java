package DSA;
import java.util.Random;

public class BubbleSort {

    public int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for(int i =0;i< length ; i++){
            for (int j =0;j<length - 1- i ;j++){
                if( arr[j] > arr[j+1] ){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
            System.out.println();
            print(arr);
            
        }
        return arr;
    }
    public void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        
        // Integer[] arr = new Integer[] { 5, 4, 3, 2, 1 };
        // List<Integer> list = Arrays.asList(arr);
        // Collections.sort(list);
        // System.out.println("Sorted array:");
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(30);
        }
        BubbleSort obj = new BubbleSort();
        obj.print(arr);
        arr = obj.bubbleSort(arr);
        System.out.println("\nSorted array:");
        obj.print(arr);





    }
}
