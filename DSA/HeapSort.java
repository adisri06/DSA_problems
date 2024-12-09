package DSA;

public class HeapSort {
    public void heapSort(int[] arr, int length){
        for(int i =length/2 -1; i>=0;i--){
            heapify(arr,length,i);
        }
        for (int i =length -1 ; i>=0;i--){
                        // Swap the root (smallest element) with the last element
            swap(arr, 0, i);
            heapify(arr, i, 0);

        }
    }
    public void heapify(int[] arr, int length, int index){
        //initialize smallest as root 
        int smallest = index;
        int left = 2*index +1;
        int right = 2*index +2;
        if(left<length && arr[smallest]>arr[left]){
            smallest = left;
        }
        if(right<length && arr[smallest]>arr[right]){
            smallest = right;
        }
             // If smallest is not root, swap and continue heapifying
             // Continue heapify from the new root
        if (smallest != index){
            swap(arr, smallest, index);
            heapify(arr, length, smallest);
        }
    }
    public void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static void main(String[] args) {
        GenerateArray arr = new GenerateArray(10);
int[] arr1 = arr.generate();
System.out.println("Generated Array is :");
arr.print(arr1);
HeapSort obj = new HeapSort();
obj.heapSort(arr1, arr1.length);
System.out.println("\nSorted array:");
arr.print(arr1);
    }

}
