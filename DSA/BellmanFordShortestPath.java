

public class BellmanFordShortestPath {
    class Node{
        int source;
        int destination;
        int weight;
        public Node(int source, int destination, int weight ){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public class NodeInfo{
        int distance;
        int parent;

        public NodeInfo(int distance , int parent ) {
            this.distance = distance;
            this.parent = parent;
        }
        
    }
    public void bellamnFord(int vertices, int edgesCount, Node[] edgess, int source){

        //Array of objects are created to store the distance and parent of each node
        NodeInfo[] nodeinfo = new NodeInfo[vertices];

        for (int i =0;i< vertices ;i++){
            // we set the distance as infinity for all the nodes, and parent as -1 for all the nodes
            nodeinfo[i] = new NodeInfo(Integer.MAX_VALUE, -1);
        }
        // making distance of source node as 0
        nodeinfo[source].distance = 0;

        //Bellman ford algorithm
        for (int i =1;i< vertices ;i++){
            for (Node edges : edgess) {
                int u = edges.source;
                int v = edges.destination;
                int weight = edges.weight;
                if(nodeinfo[u].distance != Integer.MAX_VALUE && nodeinfo[u].distance + weight < nodeinfo[v].distance){
                    nodeinfo[v].distance = nodeinfo[u].distance + weight;
                    nodeinfo[v].parent = u;
                }
            }
        }

        //check for negative cycles
        for (Node edges : edgess) {
            int u = edges.source;
                int v = edges.destination;
                int weight = edges.weight;
                if(nodeinfo[u].distance != Integer.MAX_VALUE && nodeinfo[u].distance + weight < nodeinfo[v].distance){
                    System.out.println("Graph contains a negative weight cycle");
                    nodeinfo[v].parent = u;
                    return;
                }
            
        }

        printSolution(nodeinfo, vertices, source);

    }
    private  void printSolution(NodeInfo[] nodes, int vertices, int source) {
        System.out.println("Vertex\tDistance from Source\tPath");
        for (int i = 0; i < vertices; i++) {
            if (nodes[i].distance == Integer.MAX_VALUE) {
                System.out.println(i + "\t\tINF\t\t\t-");
            } else {
                System.out.print(i + "\t\t" + nodes[i].distance + "\t\t\t");
                printPath(nodes, i, source);
                System.out.println();
            }
        }
    }
    private  void printPath(NodeInfo[] nodes, int vertex, int source) {
        if (vertex == source) {
            System.out.print(source);
            return;
        }
        //	•	If the current vertex is not the source, the method calls itself with the parent of the current vertex.

        printPath(nodes, nodes[vertex].parent, source);
        System.out.print(" -> " + vertex);
    }
    public static void main(String[] args) {
        BellmanFordShortestPath obj = new BellmanFordShortestPath();
        int vertices = 5;
        int edgesCount = 9;
        Node[] edges = obj.initializeEdges();
        //We gava 0 as the source node because we want to find the shortest path from the source node to all other nodes
        obj.bellamnFord(vertices,edgesCount, edges,0);
    

    }
    public Node[] initializeEdges() {
        return new Node[] {
            new Node(0, 1, -1),
            new Node(0, 2, 4),
            new Node(1, 2, 3),
            new Node(1, 3, 2),
            new Node(1, 4, 2),
            new Node(3, 2, 5),
            new Node(3, 1, 1),
            new Node(4, 3, -3),
            new Node(4, 0, 6)
        };
    }

}
