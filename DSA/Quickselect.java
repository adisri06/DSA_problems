package DSA;

public class Quickselect {
    public int quickSelect(int[] arr, int start, int end, int k){
        System.out.println("\ninside quickselect start: "+start+" end: "+end);
        int position = -1;
        while(start < end){
            int mid = partition(arr, start, end);
            if(mid == k){
                System.out.println("mid: "+mid);
            return mid; 
            }else if(mid < k){
                start = mid +1; 
            }
            else {
                end = mid -1;
            }
            }
            return position;
        }

        public int partition(int[] arr, int start, int end){
            int pivot = arr[end];
            int smallpointer = start -1;
            for (int j = start;j<end ;j++){
                if(arr[j]<=pivot){
                    smallpointer++;
                    swap(arr, smallpointer, j);
                }
            }
            swap(arr, smallpointer + 1, end);
            return smallpointer + 1;
        }
        public void swap(int[] arr, int first, int second){
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    
public static void main(String[] args) {
    GenerateArray arr = new GenerateArray(10);
int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10};
System.out.println("Generated Array is");
arr.print(arr1);

Quickselect obj = new Quickselect();
int k =11;
int start =0;
int end = arr1.length -1;
int result = obj.quickSelect(arr1, start, end, k);
if (result == -1){
    System.out.println("ELement not found");
}else{
    
    System.out.println(" Element found at position ");
}
}
}
