package DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashmapsDemo {

    public static void main(String[] args) {
        // The Map interface represents a key-value pair collection.
        // Coding to it promotes flexibility by allowing easy switching between implementations (e.g., TreeMap, LinkedHashMap).
        Map<String, String> map = new HashMap<>();
        map.put("Adi.sri", "shubham");
        map.put("Adi.sris", "srivastava");
        map.put("Adi.srivas", "shu");
        System.out.println(map);

        //Using keySet(): Iterates through the keys and retrieves values using the get() method.
        //The keySet() method is ideal when you only need to process or use the keys, and the values are secondary.
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println("User-id: " + key + ", Name: " + value);
        }
        /// Get all key-value pairs from the map as a Set of Map.Entry objects
        ///The entrySet() method provides direct access to both keys and values without needing additional lookups, making it more efficient than the keySet() method.
        Set entries = map.entrySet();
        for(Object entry: entries){
            //	(Map.Entry) entry: Casts each entry to Map.Entry to access its methods.
            Map.Entry mapentry = (Map.Entry) entry;
            Object key = mapentry.getKey();
            Object value = mapentry.getValue();
            System.out.println("User-id: " + key + ", Name: " + value);
        }

        
        map.putIfAbsent("Adi.", "shubham");
        System.out.println(map);
    }
}
