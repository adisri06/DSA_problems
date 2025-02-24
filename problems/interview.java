import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class interview {

public static void main(String[] args) {
     String s= "Hello My name is Shubham";
     List<Character> list = List.of('A','E','I','O','U','a','e','i','o','u');
    //  s= s.toUpperCase();
     s.chars().mapToObj(x->(char)x).filter(x-> !list.contains(x))
     .forEach(System.out::print);
        // System.out.println("Value is "+ distinctcheck(s));
        // String s1 = "ABC";
        // String s2 = "BCAd";
        // System.out.println("Value is "+ isAnagram(s1,s2));
    //     int x = 12344231;
    // List<Integer> list = new ArrayList<>();
    // while(x>0){
    //     list.add(x %10);
    //     x = x/10;
    // }
    // System.out.println("Value is "+ max_possible(list));

}
public static int  max_possible(List<Integer> list){
    Collections.sort(list, Collections.reverseOrder());
    int sum =0;
    sum += list.get(0);
    for(int i=1;i<list.size();i++){
       sum = sum*10 + list.get(i);
    }
    
return sum;
}
public static boolean isAnagram(String s, String t) {
    if(s.length()!= t.length()) return false;
    Map<Character,Integer> maps = new HashMap<>();
    for(Character val:s.toCharArray()){
        maps.put(val,maps.getOrDefault(val, 0)+1);
       
    }
    for(Character val:t.toCharArray()){
        maps.put(val,maps.getOrDefault(val, 0)+1);
       
    }
    for(Map.Entry<Character,Integer> entry:maps.entrySet()){
        if(entry.getValue()%2!=0){
            return false;
        }
    }

    return true;
}
public static char distinctcheck(String s){
    // return s.chars()
    //             .mapToObj(c -> (char) c)  // Convert to Character stream
    //             .filter(c -> Collections.frequency(s.chars().mapToObj(ch -> (char) ch).toList(), c) == 1)  // Check frequency
    //             .findFirst()
    //             .orElse(' ');
    char c = ' ';
    Map<Character,Integer> maps = new HashMap<>();
        for(Character val:s.toCharArray()){
            System.out.print(val);
            maps.put(val,maps.getOrDefault(val, 0)+1);

    }
    for(Character val:s.toCharArray()){
        if(maps.get(val)==1){
            c = val;
            break;
        }
    }
    return c;

}}
