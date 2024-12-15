package DSA;

import java.util.Random;

public class SkipList {
    public final int max_level = 4;
    private final Node head;
    private final Random random;

    public SkipList() {
        // By using a distinct value like -1, it’s easy to recognize that this is a
        // dummy node and not part of the actual data.
        // and • Creates a head node with forward pointers for all levels (0 to
        // max_level).
        random = new Random();
        head = new Node(-1, max_level);
    }

    public class Node {

        // Since the number of levels a node participates in varies, we need an array
        // (Node[level + 1]) to hold forward pointers for all the levels it belongs to.
        // • forward[0]: Points to the next node at level 0 (base level).
        // • forward[1]: Points to the next node at level 1, and so on.
        int data;
        Node forward[];

        public Node(int data, int level) {
            this.data = data;
            // At each level, a node has a pointer (forward) to the next node at that level.
            this.forward = new Node[level + 1];
        }
    }

    private int randomLevel() {
        int level = 0;
        // • Randomly returns true or false with equal probability (50% chance for
        // either).
        // • If the random value is true, it increments the level.
        while (random.nextBoolean() && level < max_level) {
            level++;
        }
        return level;
    }

    public void insert(int value) {
        // keep track of the nodes that need to be updated at each level when inserting
        // or deleting a node in the skip list.
        Node[] update = new Node[max_level + 1];
        Node current = head;
         for (int i = max_level; i>=0; i--){
            while(current.forward[i]!= null && current.forward[i].data < value){
                current = current.forward[i];
            }

            //•	After finishing traversal at level i, store the last node visited (current) in the update array.
	//•	This node is the one whose forward pointer might need to be updated (e.g., during insertion or deletion).
            update[i] =current;
         }
         int level = randomLevel();
         Node newNode = new Node(value, level);
         for (int i =0; i<=level ; i++){
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i]= newNode;
         }

    }
    public void print() {
        for (int i = max_level; i >= 0; i--) {
            Node current = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }
    public boolean search(int value){
        Node current = head; 
        for (int i = max_level;i>= 0; i --){
            while(current.forward[i]!=null && current.forward[i].data <value){
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current !=null && current.data ==value;
    }
    public void delete (int value){
        Node[] update = new Node[max_level+1];
        Node current = head;
        for(int i = max_level; i>=0; i--){
            while(current.forward[i]!=null && current.forward[i].data < value){
                current = current.forward[i];
            }
         update[i] = current ;
        }
        current = current.forward[0];
        if(current!=null && current.data == value){
            for(int i =0; i<=max_level; i++){
                // Stop if no further levels to update
                if(update[i].forward[i] !=current){
                    break;
                }
                update[i].forward[i] = current.forward[i];
                System.out.println("Deleted " + value);
            }
        }
        else{
            System.out.println("Element not found");
        }
    }
    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(5);
        skipList.insert(10);
        skipList.insert(7);
        skipList.insert(20);
        skipList.insert(15);
        skipList.insert(2);

        System.out.println("Skip List after insertions:");
        skipList.print();

        System.out.println("\nSearch results:");
        System.out.println("Find 10: " + skipList.search(10)); // true
        System.out.println("Find 23: " + skipList.search(23));   // false

        skipList.delete(7);
        skipList.print();

        skipList.delete(1);
        skipList.print();




    }

}
