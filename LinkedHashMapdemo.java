
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapdemo {
    LinkedHashMap<String,String> map = new LinkedHashMap<>();
    
    public void add(String keys,String values){
        boolean b = map.containsKey(keys);
        if(b == true){
            System.out.println("Key already exist,Updating Records");
           
        }
         // The Map interface represents a key-value pair collection.
        this.map.put(keys, values);
    }
    public void print(){
        Set entries = map.entrySet();
        for(Object entry: entries){
             Map.Entry mapentry = (Map.Entry) entry;
             Object key = mapentry.getKey();
             Object value = mapentry.getValue();
             System.out.println("User-id: " + key + ", Name: " + value);
        }
    }
    public boolean  checkKey(String key){
        return map.containsKey(key);
    }

    public String getdata(String key){
        return map.get(key);
    }

    public void removing(String key){
        boolean b = map.containsKey(key);
        if(b == false){
            System.out.println("Key does not exist");
            return;
        }
        map.remove(key);
    }
    public static void main(String[] args) {
        LinkedHashMapdemo obj = new LinkedHashMapdemo();
        obj.add("Adi.sri", "shubham");
        obj.add("Adi.sris", "srivastava");
        obj.add("Adi.srivas", "shu");
        obj.print();     

        //IF key already exist then it will overwrite the value and sequence remains the same
        //else it will add new key-value pair at end of the map and maintains insertion order
        obj.add("Adi.sris", "sri");
        obj.print();        


        //containsKey() method is used to check if a key exists in the map
        System.out.println(obj.checkKey("Adi.sri"));

        //get() method is used to retrieve the value associated with a given key
        System.out.println(obj.getdata("Adi.sri"));

        //If key does not exist, get() method returns null
        System.out.println(obj.getdata("Adi"));

       




    }
}
