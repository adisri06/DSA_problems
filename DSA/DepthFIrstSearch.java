package DSA;

import java.util.ArrayList;
import java.util.List;

public class DepthFIrstSearch {
    int time = 0; // Global time counter
class Node {
    int data;
    boolean isvisited;
    Node parent;
    int discoverytime;
    int finishedtime;
    List<Node> adjacenyList;
    Node (int value){
        this.data = value;
        this.isvisited = false;
        this.parent = null;
        this.discoverytime = -1;
        this.finishedtime = -1;
        this.adjacenyList = new ArrayList<>();

    }
    public void addNeighbor(Node node) {
        this.adjacenyList.add(node);
    }
}
public void dfs(Node node){
    if (node.isvisited){
        return;
    }
    time = time++;
    node.discoverytime = time;
    node.isvisited = true;
        System.out.println("Visiting Node " + node.data + " | Discovery Time: " + node.discoverytime);
        
    for (Node neighbor: node.adjacenyList){
        if(!neighbor.isvisited){
            neighbor.parent = node;
            neighbor.discoverytime = time;
            dfs(neighbor);
        }
    }
    time++;
    node.finishedtime = time;
    System.out.println("Finished Node " + node.data + " | Finish Time: " + node.finishedtime);



}
public void printNodeDetails(Node node) {
    System.out.println("Node " + node.data + ":");
    System.out.println("  Seen: " + node.isvisited);
    System.out.println("  Discovery Time: " + node.discoverytime);
    System.out.println("  Finish Time: " + node.finishedtime);
    System.out.println("  Parent: " + (node.parent != null ? node.parent.data : "null"));
}
public static void main(String[] args){
    DepthFIrstSearch obj = new DepthFIrstSearch();
    // Create nodes
    Node node1 = obj.new Node(1);
    Node node2 = obj.new Node(2);
    Node node3 = obj.new Node(3);
    Node node4 = obj.new Node(4);
    Node node5 = obj.new Node(5);
    Node node6 = obj.new Node(6);
    Node node7 = obj.new Node(7);

    // Create a graph by adding edges
    node1.addNeighbor(node2);
    node1.addNeighbor(node3);
    node2.addNeighbor(node4);
    node2.addNeighbor(node5);
    node3.addNeighbor(node6);
    node3.addNeighbor(node7);

    // Perform DFS starting from node1
    System.out.println("Depth First Search Traversal:");
    obj.dfs(node1);

    System.out.println("\nNode Details:");
    obj.printNodeDetails(node1);
    obj.printNodeDetails(node2);
    obj.printNodeDetails(node3);
    obj.printNodeDetails(node4);
    obj.printNodeDetails(node5);
    obj.printNodeDetails(node6);
    obj.printNodeDetails(node7);

}
}
