import java.util.LinkedList;
import java.util.Scanner;



public class LinkedListExample {

    public static void main(String[] args) {
        LinkedListExample example = new LinkedListExample();
        LinkedList<String> names = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter each item of a list and to close press double enter ");
        while(true)
        {
            String input = scanner.nextLine();
            if(input.isEmpty()){
                // So when user doesnt enter anything and hit enter it will break 
                break;
            }
            names.add(input);
        }
        example.swap(names);
        System.out.println("The linked list is:");
        for (String output : names) {
            System.out.print(output + " -> ");
        }
        
        if(!names.isEmpty()){
            System.out.println("Starting node of a list "+ names.getFirst());
            System.out.println("Last node of a list "+ names.getLast());

        }


        scanner.close();
    }
    public LinkedList<String> swap(LinkedList<String> names){
        System.out.println("Executing swap :");
        int size = names.size();
        System.out.println("size is:" + size);
        if (size < 2) {
            return null;
        }
        int middleindex = size/2;
        int i,j;
        for ( i = middleindex ,j = size -1 ; i< j ;i++, j--){

            String temp = names.get(i);
            names.set(i, names.get(j));
            names.set(j, temp);
        }


        return names;


    }
}
