import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSShortestPathDAG {
     class Node {
        int destination;
        int weight ;
        public Node (int destination, int weight ){
            this.destination = destination;
            this.weight = weight;
        }
     }
     public void shortestPath(Map<Integer,List<Node>> graph, int source, int vertices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] =0;
        queue.add(source);
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for (Node neighbor: graph.getOrDefault(currentNode, new ArrayList<>())){
                int newDistance = distance[currentNode]+ neighbor.weight;
                if(newDistance < distance[neighbor.destination]){
                    distance[neighbor.destination] = newDistance;
                    queue.add(neighbor.destination);
                }
            }
        }
        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Node " + i + ": Distance = " + (distance[i] == Integer.MAX_VALUE ? "Infinity" : distance[i]));
        }
    
        
     }
    public static void main(String[] args) {
        BFSShortestPathDAG obj = new BFSShortestPathDAG();
        int vertices = 6;
        Map<Integer, List<Node>> graph = new HashMap<>();
         graph.computeIfAbsent(0, k -> new ArrayList<>()).add(obj.new Node(1, 2));
        graph.computeIfAbsent(0, k -> new ArrayList<>()).add(obj.new Node(2, 4));
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(obj.new Node(3, 7));
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(obj.new Node(4, 1));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(obj.new Node(3, 3));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(obj.new Node(5, 1));
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(obj.new Node(5, 2));

        int source = 0;
        obj.shortestPath(graph, source, vertices);

    }
}
