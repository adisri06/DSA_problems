import java.util.ArrayList;

public class Course {
    public void displaydays(String [] daysofweek){
        //data type is implicitly defined and the elements are added to the array during its creation.\
    
        String[ ] monthsOfYear = new String[ ]
        { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        for (String string : monthsOfYear) {
            System.out.println(string);  
        }
        for (String string : daysofweek) {
            System.out.println(string);  
        }
        
    }
    public void ArrayListExample(){
        //Declaring of a arrayList
        //<Its generic type is String means it can store only String values and we dont have to type cast>
        //we can define generics by using <> on basis of the data type arraylist will store
        
        ArrayList<String> items = new ArrayList<>();
        items.add("item1");
        items.add("item2");
        //To insert element at certain index
        items.add(2, "item no 6 at index 2");
        items.add("item3");
        System.out.println(items.size()); //To get the size of the list

        //IN java we mostly use .getClass() to get the type of the object
        System.out.println((items.get(1).getClass()));

        // As the index starts from 0 and it will return always an object type so we have to type cast it to string
        Object obj = items.get(1);

        System.out.println((String)obj); //Type casting a particular object to string
        System.out.println(items.remove(1)); //To remove at certain index
        if(items.isEmpty()){
            //To check if list is empty
            System.out.println("ArrayList is empty");
        }
        if(items.contains("item1")){
            //To check if the list contains an item1
            System.out.println("ArrayList contains item1");
        }
        for (Object item : items) {
            //Foreach loop to iterate over the list
            if((item.toString().length()) > 5){
                System.out.println("The lenght is "+ item.toString().length());
                
            }
            System.out.println(item);
        }
        items.clear();

    }
    public static void main(String[] args) {
        Course course = new Course();
        String [] daysofweek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        // course.displaydays(daysofweek);
        course.ArrayListExample();
    }

}
