import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StacksImplementation {
    private int stack[];
    private int top;
    private Node head;

    public class Node{
        String data;
        Node next;
        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public StacksImplementation(){
        this.head = null;
    }
    public void push(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }
    public String popping(){
        if(head == null){
            System.out.println("Stack is empty");
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public String peeking(){
if(head ==null){
    System.out.println("Stack is empty");
    return null;
}
else{
    return head.data;
}
    }
    public StacksImplementation(int size){
        stack = new int[size];
        top = -1;
    }
    public void push(int data){
       if(top == stack.length-1){
           System.out.println("Stack is full");
           return;
       }
       stack[++top] = data;
    }
    void pushqueue(int data){
        if(top = =)
    }
    public int pop(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top--];
    }
    public int peek(){
        if(top == -1){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }

    public static void main(String[] args) {

        //he Stack object is created successfully because Stack is a class in Java, not an interface. 
        //Specifically, it's a class in the java.util package that implements the Vector class and provides a last-in-first-out (LIFO) data structure.
//In contrast, Queue is an interface in Java, not a class. It's defined in the java.util package and provides a first-in-first-out (FIFO) data structure, but it cannot be instantiated directly.
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        // Push elements onto the stack
        stack.push("www.google.com");
        stack.push("www.facebook.com");
        stack.push("www.youtube.com");

        //push elements onto the queue
        
        queue.add("www.google.com");
        queue.add("www.facebook.com");
        queue.add("www.youtube.com");

        //peek elements from stack
        System.out.println(stack.peek());

        //peek elemets from queue
        System.out.println(queue.peek());

        // Pop elements from the stack
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

        // Pop elements from the queue
        while(!queue.isEmpty()){
            System.out.println(queue.remove());
        }

        StacksImplementation obj = new StacksImplementation(10);

        // Array Implementation
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        System.out.println(obj.peek());

        // Linked List Implementation
        StacksImplementation obj1 = new StacksImplementation();
        obj1.push("www.faceboofasfasfk.com");
        obj1.push("www.gaga.com");
        obj1.push("www.Shubham  \n Srivastava.com");

        System.out.println(obj1.popping());
        System.out.println(obj1.peeking());

}
}
