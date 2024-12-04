
import java.util.LinkedList;

public class groceryitems {
    LinkedList<String> items = new LinkedList<String>(); // <String>
    public void additem(String name){
        items.add(name);
        
    }
    public void setitem(int index, String name){
        items.set(index, name);
    }

    public void removeitem(String name){
        for (String str : items) {
            if (str.equals(name))
            {
                items.remove(str);
            }
        }
        
    }
public static void main(String[] args) {
    groceryitems obj = new groceryitems();
    obj.additem("bread");
    obj.additem("milk");
    obj.additem("butter");
    obj.additem("eggs");
    System.out.println(obj.items);

    obj.setitem(0, "butter");
    System.out.println(obj.items);

    obj.removeitem("eggs");
    System.out.println(obj.items);
    
}
}
