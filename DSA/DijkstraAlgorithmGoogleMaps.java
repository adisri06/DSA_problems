import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithmGoogleMaps {
    class Node{
        int source;
        int Destination;
        int weight;
        public  Node(int source, int Destination, int weight){
            this.source = source;
            this.Destination = Destination;
            this.weight = weight;
        }
    }
    class NodeInfo{
        int node;       
        int distance;
        int parent;
        boolean isvisited;
        public NodeInfo(int node,int distance, int parent){
            this.node = node;
            this.distance = distance;
            this.parent = parent;
            this.isvisited = false;
        }
    }
    class Graph{
        List<Node> edges = new ArrayList<>();
         public void addEdge (int source, int destination, int weight){
            edges.add(new Node(source, destination, weight));
            edges.add(new Node(destination, source, weight));

         }
    }
    public void dijkstra(List<Node> edges, int source, int vertices)
    {
    Map<Integer, List<Node>> adjacencyListNode = new HashMap<>();
        for (Node edge: edges){
            adjacencyListNode.computeIfAbsent(edge.source, key -> new ArrayList<>()).add(edge);
        }
        Map<Integer, NodeInfo> nodeInfoMap = new HashMap<>();

        for(int i=0;i<vertices;i++){
            nodeInfoMap.put(i, new NodeInfo(i,Integer.MAX_VALUE, -1));
        }
        nodeInfoMap.get(source).distance = 0;
        PriorityQueue<NodeInfo> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));        pq.add(nodeInfoMap.get(source));
        while(!pq.isEmpty()){
            NodeInfo current = pq.poll();
            if(current.isvisited) continue;
            current.isvisited = true;
            int currentNodeInfo = current.node;
            for (Node node : adjacencyListNode.getOrDefault(currentNodeInfo, new ArrayList<>())) {
                int newDistance = node.weight + current.distance;
                NodeInfo neighbourInfo = nodeInfoMap.get(node.Destination);
                if(newDistance < neighbourInfo.distance){
                    neighbourInfo.distance = newDistance;
                    neighbourInfo.parent = currentNodeInfo;
                    pq.add(neighbourInfo);
                }
                
            }
        }

        for (Map.Entry<Integer, NodeInfo> entry : nodeInfoMap.entrySet()) {
            NodeInfo info = entry.getValue();
            System.out.println("Node " + info.node + ": Distance = " + info.distance + ", Parent = " + info.parent);
        }

    }

   



    public static void main(String[] args) {
      DijkstraAlgorithmGoogleMaps obj = new DijkstraAlgorithmGoogleMaps();
        Graph graph = obj.new Graph();
        // Add edges to the graph
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 3, 4);
        graph.addEdge(0, 5, 1);
        graph.addEdge(1, 2, 7);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 2, 6);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 2);
        graph.addEdge(4, 6, 8);
        graph.addEdge(5, 6, 9);

        int source =0;
        int vertices =7;
        obj.dijkstra(graph.edges, source,vertices);

    }
}