package DSA;


public class RedBlackTreeRotation_Right_left {
    public class Node{
        int data;
        Node left, right, parent;
        String color;
        public Node(int data, String color){
            this.data = data; 
            this.left = null;
            this.right = null; 
            this.color = color; 
            this.parent = null;
    
    
        }}
    private Node root;
    private final Node LeaveNode; // Sentinel node
    
    public RedBlackTreeRotation_Right_left() {
        LeaveNode = new Node(0, "black");
        root = LeaveNode;

    }
    /*     x
         /  \
        z    y
       /    / \
      a    T1   T2

      */
    
    public void LeftRotation (Node x){
        //Identify y (the right child of x):
        Node y = x.right;
        //Move y’s left subtree (T1) to be x’s right subtree: as T1 is greater than y but less than x
        x.right = y.left;
        y.left = x;
        //Update y’s parent to match x’s parent:
        y.parent = x.parent;
        //Adjust the parent of x to point to y:
        if(x.parent == null){
            root =y; //// If x was the root, y becomes the new root
        }
        else if(x == x.parent.left){
            x.parent.left =y;
        }
        else {
            x.parent.right =y;
        }
        //Now make x as child of y
        y.left = x;
        x.parent = y;

    //     y
    //     / \
    //    x   T2
    //     \
    //      T1
    }

    /* right rotation
    x
    /   \
   z     y
  / \   / \
 a   b T1  T2 */
    public void RightRotation (Node x){
        //Identify z (the left child of x):
        Node z = x.left;
        //Move z’s right subtree (b) to be x’s left subtree:
        x.left = z.right;
        z.right =x;
        //Update z’s parent to match x’s parent:
        z.parent = x.parent;
        //Adjust the parent of x to point to z:
      if(x.parent == null){
          root =z; //// If x was the root, z becomes the new root
      }
      else if(x == x.parent.left){
        x.parent.left =z;
      }
      else {
        x.parent.right =z;
      }
        //Now make x as child of z
        z.right = x;
        x.parent = z;
/*
          z
        /   \
       a     x
            / \
           b   y
              / \
             T1  T2
 */

    }
    public void printTree(Node node, String indent, boolean last) {
        if (node != LeaveNode) { // Stop printing if we reach the sentinel node
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println("(" + node.data + ", " + node.color + ")");
            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }


    // Helper to print the root tree
    public void printTree() {
        printTree(this.root, "", true);
    }
    public static void main(String[] args) {
        RedBlackTreeRotation_Right_left tree = new RedBlackTreeRotation_Right_left();

        // Create nodes for testing
        Node node1 = tree.new Node(10, "BLACK");
        Node node2 = tree.new Node(20, "RED");
        Node node3 = tree.new Node(30, "RED");
        Node node4 = tree.new Node(15, "BLACK");
        Node node5 = tree.new Node(25, "BLACK");
        Node node6 = tree.new Node(5, "RED");
        Node node7 = tree.new Node(7, "BLACK");
        Node node8 = tree.new Node(35, "RED");

        // Build a simple tree structure
        tree.root = node1; // Set the root of the tree
        node1.left = node6;
        node1.right = node2;

        node6.parent = node1;
        node6.right = node7;
        node6.left = tree.LeaveNode; // Sentinel node

        node7.parent = node6;
        node7.left = tree.LeaveNode; // Sentinel node
        node7.right = tree.LeaveNode; // Sentinel node

        node2.parent = node1;
        node2.left = node4;
        node2.right = node3;

        node4.parent = node2;
        node4.left = tree.LeaveNode; // Sentinel node
        node4.right = tree.LeaveNode; // Sentinel node

        node3.parent = node2;
        node3.left = tree.LeaveNode; // Sentinel node
        node3.right = node8;

        node8.parent = node3;
        node8.left = tree.LeaveNode; // Sentinel node
        node8.right = tree.LeaveNode; // Sentinel node

        // Print before rotation
        System.out.println("Before left rotation root node is " + tree.root.data + ":");
        tree.printTree();

        // Perform left rotation at node1
        tree.LeftRotation(node1);

        // Print after rotation
        System.out.println("\nAfter left rotation: and root node is " + tree.root.data);
        tree.printTree();
        tree.RightRotation(node2);
        System.out.println("\nAfter right rotation: and root node is " + tree.root.data);
        tree.printTree();
    }    
}
