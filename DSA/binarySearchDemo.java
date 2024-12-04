package DSA;

public class binarySearchDemo {
    public boolean binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;
        int operations =0;
        while(start<=end){
            operations++;
            int mid = (start + end )/2;
            System.out.println("Start : "+start+" End : "+end+" Mid : "+mid);
            if(arr[mid] == target){
                int rindex = mid;
                int lindex = mid;
                int totalOcurrence = 0;
                
                //count the right side of occurrence
                while(rindex < arr.length && arr[rindex] == target){
                    System.out.println("rindex: "+rindex);
                    totalOcurrence++;
                    rindex++;
                }

                //count the left side of occurrence
                while(lindex >= 0 && arr[lindex] == target){
                    System.out.println("lindex: "+lindex);
                    totalOcurrence++;
                    lindex--;
                }
                
                //display the total occurrence and number of operations
                System.out.println("Total Ocurrence: "+totalOcurrence);
                System.out.println("No of operations: "+operations);
                return true;
            }
            else{
                if(arr[mid]<target){
                    start = mid +1;

                }
                else{
                    end = mid -1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = i;
            }
            for (int i = 50; i < 60; i++) {
                arr[i] = 50;
            }
            int target =50;
            binarySearchDemo obj = new binarySearchDemo();
            boolean result = obj.binarySearch(arr, target);
    //         List<Integer> integerlist = new ArrayList<>();
    // for(int i = 0; i < 100; i++) {
    //     integerlist.add(i);
    //     }   
    //     for(int i = 50; i < 60; i++) {
    //         integerlist.add(i, 50);
    //         }  
    //         Collections.sort(integerlist);
    //         int target =50;
            // int index = Collections.binarySearch(integerlist, target);
             System.out.println(result);
}
}
