import java.util.LinkedList;
import java.util.ListIterator;

public class doublelinkedlist {
    Node head;
    Node tail;

    doublelinkedlist() {
            this.head = null;
            this.tail = null;
        }
    public class Node{
        String data;
        Node next;
        Node prev;

        public Node( String dataIn) {
            this.data = dataIn;
            this.next = null;
            this.prev = null;
        }
        
    }
    public void addFront(String dataIn){ {
        Node newNode = new Node(dataIn);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
    }}
    public void addBack(String dataIn){
         Node newNode = new Node(dataIn);
         if(tail == null){
            head = newNode;
            tail = newNode;
         }
         else{
           newNode.prev = tail;
           tail.next = newNode;
           tail = newNode;
         }
    }
    public void add(String dataIn, Node prevNode){
        if(prevNode == null){
            addFront(dataIn);

        }
        else{
            Node newNode = new Node(dataIn);
            newNode.next= prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            if(newNode.next != null){
                newNode.next.prev = newNode;
            }
            else{
                tail = newNode;
            }

        }
    }
    public void traverseForward() {
        Node current = head;
        while (current != null) {
        System.out.print(current.data + " ");
        current = current.next;
        }
        System.out.println();
        }
    public void traverseBackward() {
        Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev; 
        }
        System.out.println();
    }
    public void removeFront(){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            head = head.next;
            if(head != null){
                head.prev = null;

            }
            else{
                tail = null;
            }
        }
    }
    public void removeBack(){
        if(tail == null){
            System.out.println("List is empty");
        }
        else{
            tail = tail.prev;
            if(tail != null){
                tail.next = null;
            }
            else{
                head = null;
            }
        }
    }
    public void remove(Node node){
    if(head == null){
        System.out.println("List is empty");        
    }
    else{
        if(node == head){
            removeFront();
        }
        else if(node == tail){
            removeBack();
        }
        else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
}
    public static void main(String[] args) {
        doublelinkedlist obj = new doublelinkedlist();
        // obj.addFront("A");
        // obj.addBack("B");
        // obj.add("C", obj.head);
        // obj.traverseForward();
        // obj.traverseBackward();
        // obj.removeFront();
        // obj.traverseForward();
        // obj.removeBack();
        // obj.traverseForward();
        // obj.remove(obj.head.next);
        // obj.traverseForward();

       LinkedList<String> recipeSteps = new LinkedList<>();
       ListIterator<String> recipeStepsIterator = recipeSteps.listIterator();

        recipeSteps.add("shubham");
        recipeSteps.addFirst("Mr");
        recipeSteps.addLast("Srivastava");
        while (recipeStepsIterator.hasNext()) {
            System.out.println(recipeStepsIterator.next());
        }
        System.out.println("\nTraversing backward through the recipe:");
        while (recipeStepsIterator.hasPrevious()) {
            System.out.println(recipeStepsIterator.previous());
        }
        recipeSteps.removeFirst();
        recipeSteps.removeLast();
        System.out.println(recipeSteps);
        recipeSteps.remove("shubham");
        System.out.println(recipeSteps);

        // TODO Auto-generated method stub
        System.out.println("Hello World!");

    }
}
