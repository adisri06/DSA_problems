package DSA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchGraphs {
    public class Node {
        int data;
        boolean isVisited;
        Node parent;
        int depth;
        List<Node> AdjacentNeighbours;

        public Node(int value) {
            this.data = value;
            this.isVisited = false;
            this.AdjacentNeighbours = new ArrayList<>();
            this.parent = null;
            this.depth = 0;
        }

        public void addNeighbour(Node node) {
            this.AdjacentNeighbours.add(node);
        }
    }

    public void breadthSearch(Node start) {
        Queue<Node> queue = new LinkedList<>();
        start.depth = 0;
        start.isVisited = true;
        start.parent = null;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node u = queue.poll(); // return the top of queue or null if empty
            for (Node adjNode : u.AdjacentNeighbours) {
                if (!adjNode.isVisited) {
                    adjNode.depth = u.depth + 1;
                    adjNode.parent = u;
                    adjNode.isVisited = true;
                    queue.add(adjNode);
                }
            }
        }

    }

    public void printNodeDetails(Node node) {
        System.out.println("Node " + node.data + ":");
        System.out.println("  Seen: " + node.isVisited);
        System.out.println("  Depth: " + node.depth);
        System.out.println("  Parent: " + (node.parent != null ? node.parent.data : "null"));
    }

    public static void main(String[] args) {
        BreadthFirstSearchGraphs obj = new BreadthFirstSearchGraphs();
        Node node1 = obj.new Node(1);
        Node node2 = obj.new Node(2);
        Node node3 = obj.new Node(3);
        Node node4 = obj.new Node(4);
        Node node5 = obj.new Node(5);
        Node node6 = obj.new Node(6);
        Node node7 = obj.new Node(7);

        node1.addNeighbour(node2);
        node1.addNeighbour(node3);
        node2.addNeighbour(node4);
        node2.addNeighbour(node5);
        node3.addNeighbour(node6);
        node3.addNeighbour(node7);

        obj.breadthSearch(node1);
        obj.printNodeDetails(node1);
        obj.printNodeDetails(node2);
        obj.printNodeDetails(node3);
        obj.printNodeDetails(node4);
        obj.printNodeDetails(node5);
        obj.printNodeDetails(node5);
        obj.printNodeDetails(node6);
        obj.printNodeDetails(node7);



    }

}
