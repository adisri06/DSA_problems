package DSA;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public void insert(int data) {
        root = insertLoop(root, data);
    }

    private Node insertLoop(Node current, int data) {
        if (current == null) {
            // If the current node is null, it means we’ve reached an empty spot where the
            // new value can be placed. At this point, a new node is created with the given
            // data and returned.
            return new Node(data);
        }
        if (data < current.data) {
            // If data is less than the current node’s value, it tries to insert the value
            // in the left subtree by calling itself (current.left =
            // insertLoop(current.left, data)).
            current.left = insertLoop(current.left, data);
        } else if (data > current.data) {
            // If data is greater than the current node’s value, it tries to insert the
            // value in the right subtree.

            current.right = insertLoop(current.right, data);
        }
        // This is reached on the way back up the recursive call stack.
        // 1. After the new node is inserted, the function starts returning up the
        // stack.
        // 2. Each parent node passes itself (current) back up to its parent.
        // 3. At the top level, the root node (root) is updated with the final tree
        // structure.
        return current;
    }

    public boolean find(int data) {
        return findLoop(root, data);
    }

    public boolean findLoop(Node current, int data) {
        if (current == null) {
            //	•	If the current node is null, it means we’ve reached the end of a branch, and the value isn’t in the tree. So, we return false.
            return false;
        }
        if (current.data == data) {
            //	•	If the current node’s value matches the value we’re searching for, the value exists in the tree. Return true.
            return true;
        }
        return current.data > data ? findLoop(current.left, data) : findLoop(current.right, data);
    }

    public void delete(int data) {
        root = deleteLoop(root, data);
    }

    public Node deleteLoop(Node current, int data) {
        if (current == null) {
            //	•	If the value to be deleted (data) is not found (reaches null), it prints “Element not found” and returns null.

            System.out.println("Element not found");
            return null;
        }
        if (data < current.data) {
            current.left = deleteLoop(current.left, data);
        } else if (data > current.data) {
            current.right = deleteLoop(current.right, data);

        } else {
            // Main delete operation starts here
            // As node which needs to be deleted is found
            if (current.left == null && current.right == null) {
                //•	Simply return null, effectively removing the node from the tree.
                System.out.println("Element deleted Successfully");
                return null;
            }
            // When we return the child node (current.left or current.right), we are essentially connecting the parent of the node being deleted directly to the child.
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Node with 2 children
            current.data = findMin(current.right);
            //We call the deleteLoop function to remove the duplicate value (the smallest node we just moved to the current node).
            current.right = deleteLoop(current.right, current.data);
        }
        // •	After deleting, return the updated node back to the parent.
        return current;
    }

    public int findMin(Node current) {
        // when a node has two children, its value needs to be replaced with the smallest value that is larger than it. The smallest value on the right side is the inorder successor, which is the leftmost node in the right subtree.
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public void printTree() {
        System.out.println("Tree Structure:");
        printTreeRecursive(root, 0);
    }

    private void printTreeRecursive(Node current, int level) {
        if (current == null) {
            return;
        }
        printTreeRecursive(current.right, level + 1); // Right subtree
        System.out.println(" ".repeat(4 * level) + "-> " + current.data); // Node value
        printTreeRecursive(current.left, level + 1); // Left subtree
    }

    public void traverseInorder(Node node) {
        // Left, Root, Right
        if (node != null) {
            traverseInorder(node.left);
            System.out.print(node.data + " ");
            traverseInorder(node.right);
        }

    }

    public void preorder(Node node) {
        // Root, Left, Right
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }

    }

    public void postorder(Node node) {
        // Left, Right, Root 
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");

        }

    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.printTree();
        System.out.println("Inserting 74 and 64");

        tree.insert(74);
        tree.insert(64);
        tree.printTree();
        System.out.println("Inorder Traversal");
        tree.traverseInorder(tree.root);
        System.out.println("\nPreorder Traversal");
        tree.preorder(tree.root);
        System.out.println("\nPostorder Traversal");
        tree.postorder(tree.root);

        System.out.println("Finding 30 " + tree.find(30));
        System.out.println("Finding 10 " + tree.find(10));

        System.out.println("Deleting with no children 20");
        tree.delete(20);
        tree.printTree();

        System.out.println("Deleting with one children 60");
        tree.delete(60);
        tree.printTree();
        System.out.println("Deleting with both children 50");

        tree.delete(50);
        tree.printTree();

    }

}
