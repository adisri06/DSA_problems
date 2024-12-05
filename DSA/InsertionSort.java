package DSA;
import java.util.Random;

public class InsertionSort {

    public void print (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public int[] insertionSort(int[] arr) {
        int length = arr.length;
        for(int i =1;i< length;i++){
            int current = arr[i];
            int j =i-1;
            while(j>=0&& arr[j]>current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]= current;
        }
        return arr;
    }
public static void main(String[] args) {
    Random random = new Random();
    int arr[] = new int[10];
    for (int i =0; i< 10 ;i++){
        arr[i]= random.nextInt(100);
    }

    InsertionSort obj = new InsertionSort();
    obj.print(arr);
    arr = obj.insertionSort(arr);
    System.out.println("\nSorted array:");
    obj.print(arr);

}
}
