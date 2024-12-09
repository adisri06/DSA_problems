package DSA;

public class quickSort {
    public static GenerateArray genz = new GenerateArray(6);
    public int[] quickSorting(int[] arr, int start, int end){

        if(start< end){

            int mid = partition(arr, start, end);
            System.out.println("mid: "+mid);
            arr = quickSorting(arr, start, mid-1);
            arr = quickSorting(arr, mid+1, end);
        }
        return arr;
    }
    public int partition(int[] arr, int start, int end ){
        System.out.println("\n inside partition start: "+start+" end: "+end);
        int pivot = arr[end];
        int smallpointer = start -1;

        for (int j = start;j<end ;j++){

            if (arr[j]<=pivot){
                smallpointer++;
                int temp = arr[smallpointer];
                arr[smallpointer]= arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("Inside partition smallpointer: "+smallpointer + " pivot: "+pivot);
        int temp = arr[smallpointer + 1];
        arr[smallpointer + 1] = arr[end];
        arr[end] = temp;
        System.out.println("Final array after partition: ");

        genz.print(arr);

        return smallpointer + 1;
    }
    public static void main(String[] args) {

       
        int arr[] = genz.generate();
        System.out.println("Generated Array is :");
        genz.print(arr);
        quickSort obj = new quickSort();
        int start =0;
        int end = arr.length -1;
        System.out.println("\ninitial start: "+start+" end: "+end);
        arr = obj.quickSorting(arr, start, end);
        System.out.println("Sorted Array is :");
        genz.print(arr);


    }
}
