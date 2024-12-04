
import java.util.LinkedList;

public class search {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Shubham");
        list.add("Shi");
        list.add("Shub");
        list.add("Shubh");
        list.add("M");
        list.add("F");
        list.add("G");
        list.add("Shubh");
        list.add("Shubh");
        list.add("Shubh");


        //Linear search
        int count =-1;
        boolean flag =false;
        for (String string : list) {
            count++;
            if (string.equals("Shubh")) {
                flag = true;
                System.out.println(count);
            }
        }
        System.out.println(flag == true ? "Found": "Not Found");
  
    }
}
