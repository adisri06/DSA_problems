package DSA;

import java.util.ArrayList;
import java.util.List;

public class stream_instances {
    public static class Object {
        String name;
        String phone;
        String dob;
        int age;
        String gender;

        public Object(String name, String phone, String dob, int age, String gender) {
            this.name = name;
            this.phone = phone;
            this.dob = dob;
            this.age = age;
            this.gender = gender;
        }
    }
public static void main(String[] args) {
List<Object> list = new ArrayList<>();
list.add(new Object("John Doe", "1234567890", "1990-01-01", 31, "Male"));
list.add(new Object("Jane Doe", "9876543210", "1992-02-02", 29, "Female"));
list.add(new Object("Bob Smith", "5556667788", "1980-03-03", 41, "Male"));
list.add(new Object("Alice Brown", "5557778888", "1985-04-04", 36, "Female"));
list.add(new Object("Mike Davis", "5558889999", "1975-05-05", 46, "Male"));
list.add(new Object("Sarah Taylor", "5559990000", "1995-06-06", 25, "Female"));
list.add(new Object("David Lee", "5550001111", "1965-07-07", 56, "Male"));
list.add(new Object("Emily Chen", "5551112222", "1980-08-08", 41, "Female"));
list.add(new Object("Kevin White", "5552223333", "1970-09-09", 51, "Male"));
list.add(new Object("Olivia Martin", "5553334444", "1990-10-10", 31, "Female"));

List<Object> final_res = new ArrayList<>();
list.stream().filter(obj->obj.age>30).forEach(obj->final_res.add(obj));

List<Object> final_res2 = list.stream().filter(a->a.gender.equals("Female")).toList();
for (Object obj: final_res2){
    System.out.println(obj.name);
}
}
}
