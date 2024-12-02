import java.util.ArrayList;
import java.util.Objects;

public class Course {

    public void displayDays(String[] daysOfWeek) {
        // Data type is implicitly defined and the elements are added to the array during its creation.
        String[] monthsOfYear = {
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"
        };

        for (String month : monthsOfYear) {
            System.out.println(month);
        }

        for (String day : daysOfWeek) {
            System.out.println(day);
        }
    }

    public void arrayListExample() {
        // Declaring an ArrayList with generic type String.
        ArrayList<Friends> friendList = new ArrayList<>();
        friendList.add(new Friends("Shubham", 22));
        friendList.add(new Friends("Shub", 22));
        friendList.add(new Friends("Shubhi", 22));

        System.out.println(friendList);
        System.out.println(friendList.get(0).getName());
        System.out.println(friendList.set(0, new Friends("Am", 22)));
        System.out.println(friendList.get(0).getName());

        int index = friendList.indexOf(new Friends("Shubham", 22));
        if (index != -1) {
            System.out.println("Friend found at index " + index);
        } else {
            System.out.println("Friend not found");
        }

        ArrayList<String> items = new ArrayList<>();
        items.add("item1");
        items.add("item2");
        items.add(2, "item no 6 at index 2");
        items.add("item3");

        System.out.println(items.size());
        System.out.println(items.get(1).getClass());
        Object obj = items.get(1);

        System.out.println((String) obj);
        System.out.println(items.remove(1));

        if (items.isEmpty()) {
            System.out.println("ArrayList is empty");
        }

        if (items.contains("item1")) {
            System.out.println("ArrayList contains item1");
        }

        for (Object item : items) {
            if (item.toString().length() > 5) {
                System.out.println("The length is " + item.toString().length());
            }
            System.out.println(item);
        }

        items.clear();
    }

    public class Friends {
        private String name;
        private int age;

        public Friends(String name, int age) {
            this.name = String.valueOf(name);
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Friends friends = (Friends) o;
            return age == friends.age && Objects.equals(name, friends.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class Node {
        String name;
        String details;
        Node next;

        Node(String name, String details) {
            this.name = name;
            this.details = details;
            this.next = null;
        }
    }

    public class LinkedList {
        Node head;

        LinkedList() {
            this.head = null;
        }

        void addCustomer(String name, String details) {
            Node newNode = new Node(name, details);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        void removeCustomer(String name) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.name.equals(name)) {
                head = head.next;
                return;
            }
            Node current = head;
            while (current.next != null && !current.next.name.equals(name)) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }

        void updateCustomer(String name, String details) {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            if (head.name.equals(name)) {
                head.details = details;
                return;
            }
            Node current = head;
            while (current != null) {
                if (current.name.equals(name)) {
                    current.details = details;
                    return;
                }
                current = current.next;
            }
            System.out.println("Customer not found");
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.name + " (" + current.details + ")");
                current = current.next;
                if (current != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println(" -> null");
        }

        public void addvip(String name, String details){
            Node newNode = new Node(name, details);
            if(head == null){
                head = newNode;
                return;
            }
            else{
                newNode.next = head;
                head = newNode;
           
            }
            
        }

        public void testLinkedList() {
            LinkedList waitlist = new LinkedList();
            waitlist.addCustomer("Shubham", "Party of 1");
            waitlist.addCustomer("Shi", "Party of 2");
            waitlist.addCustomer("Shub", "Party of 5");
            waitlist.addCustomer("Shubh", "Party of 4");
            waitlist.addCustomer("M", "Party of 5");
            waitlist.printList();

            waitlist.removeCustomer("Shubham");
            waitlist.printList();

            waitlist.updateCustomer("Shi", "Party of 6");
            waitlist.printList();

            // Adding VIP customers
        waitlist.addvip("VIP Charlie", "Party of 1");
        waitlist.addvip("VIP Dave", "Party of 4");
        waitlist.printList();


        }
    }

   
    public static void main(String[] args) {
        Course course = new Course();
        course.new LinkedList().testLinkedList();
        
    }
}