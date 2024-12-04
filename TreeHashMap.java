
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class lastnamecomparator implements Comparator<Integer > {
    private  final Map<Integer, String> map;

    public lastnamecomparator(Map<Integer, String> map) {
        this.map = map;
    }
    @Override
    public int compare(Integer key1, Integer key2) {
        String name1 = map.get(key1).substring(map.get(key1).lastIndexOf(" ") + 1);
        String name2 = map.get(key2).substring(map.get(key2).lastIndexOf(" ") + 1);
        int comparison =  name1.compareToIgnoreCase(name2);
        return comparison !=0? comparison: key1.compareTo(key2);
    }
}
public class TreeHashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1, "Adi Srivastava");
        map.put(2, "Shubham Sharma");
        map.put(3, "Srivastava man");
        map.put(4, "Shubham bro");
        map.put(5, "Shubham brwwo");
        map.put(6, "Shubham brwwo");



        TreeMap<Integer, String> treeMap = new TreeMap<>(new lastnamecomparator(map));
        treeMap.putAll(map);
        for(Map.Entry<Integer, String> entry: treeMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        // 1. Getting the first and last entries
        System.out.println("First Entry: " + treeMap.firstEntry());
        System.out.println("Last Entry: " + treeMap.lastEntry());

        treeMap.remove(3);
        System.out.println("\nAfter removing key 3:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //Contains 
        System.out.println("Contains value 'Adi Srivastava': " + treeMap.containsValue("Adi Srivastava"));
        System.out.println("Contains key 1: " + treeMap.containsKey(1));

        System.out.println("\nValue for key 1: " + treeMap.get(1));

        //First key is lowest key and last key is highest key
        System.out.println("\nFirst Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());

        int keyindex =3;
        System.out.println("\nIndex of lower key " + treeMap.lowerKey(keyindex)); //Strictly lower
        System.out.println("Index of higher key: " + treeMap.higherKey(keyindex));   //Strictly higher
        System.out.println("Index of higher key: " + treeMap.ceilingKey(keyindex));   //equalto or higher
        System.out.println("Index of lower key: " + treeMap.floorKey(keyindex));   //equalto or lower


        

        
    }
}
