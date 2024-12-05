package DSA;

import java.util.Random;

public class GenerateArray {
    public int length ;
    Random Random = new Random();
    public GenerateArray(int length) {
        this.length = length;
    }
    public int[] generate(){
        int[] arr = new int[length];
        for(int i=0;i< length;i++){
            arr[i]= Random.nextInt(100);
        }
        return arr;
    }
    public void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
