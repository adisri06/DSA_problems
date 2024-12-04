
import java.util.Scanner;

public class complete_pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i =0; i< size;i++)
        {
            arr[i]= sc.nextInt();
        }

        complete_pairs obj = new complete_pairs();
        obj.pairs(arr);
        sc.close();
    }
    private int class pairs(int [] arr) {
        return 0;
    }
}
