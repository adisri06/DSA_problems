package DSA;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapdemo {
    LinkedHashMap<String,String> map = new LinkedHashMap<>();

    //LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
    //initialCapacity: The initial capacity of the map. If the number of entries exceeds this value, the map is resized to hold this many entries. The default initial capacity is 4.
    //loadFactor: The load factor of the map. The default load factor is 0.75.
    //accessOrder: If true, the map will maintain insertion order. If false, the map will not maintain insertion order.
    LinkedHashMap<String, String> amap = new LinkedHashMap<>(4, 0.75f, true);
    
    public void add(String keys,String values){
        boolean b = amap.containsKey(keys);
        if(b == true){
            System.out.println("Key already exist,Updating Records");
           
        }
         // The Map interface represents a key-value pair collection.
        // this.map.put(keys, values);
        this.amap.put(keys, values);
    }
    public void print(){
        Set entries = amap.entrySet();
        for(Object entry: entries){
             Map.Entry mapentry = (Map.Entry) entry;
             Object key = mapentry.getKey();
             Object value = mapentry.getValue();
             System.out.println("User-id: " + key + ", Name: " + value);
        }
    }
    public boolean  checkKey(String key){
        return amap.containsKey(key);
    }

    public String getdata(String key){
        return amap.get(key);

    }

    public void removing(String key){
        boolean b = amap.containsKey(key);
        if(b == false){
            System.out.println("Key does not exist");
            return;
        }
        amap.remove(key);
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
