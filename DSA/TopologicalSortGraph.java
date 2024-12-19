package DSA;

//Topological sort helps determine the correct order of execution for tasks. By arranging tasks in a way that respects their dependencies, topological sort ensures that no task starts before its prerequisites are completed.
//Build systems (e.g., Make, Gradle, Maven) often use topological sorting to determine the correct order in which to build the modules. The build system generates a sequence of build steps, ensuring that modules are built in the correct order, respecting the dependencies.
import java.util.ArrayList;
import java.util.List;

public class TopologicalSortGraph {
    public int time = 0;
    public List<Node> topologicalOrder = new ArrayList<>();

    public class Node {
        int data;
        int discoverytime;
        int finishedtime;
        boolean isvisited;
        Node parent;
        List<Node> adjacenyList;

        Node(int value) {
            this.data = value;
            this.isvisited = false;
            this.parent = null;
            this.finishedtime = -1;
            this.discoverytime = -1;
            this.adjacenyList = new ArrayList<>();
        }

        public void printAdjacencyList() {
            System.out.print("Node " + data + " -> ");
            for (Node neighbor : adjacenyList) {
                System.out.print(neighbor.data + " ");
            }
            System.out.println();
        }
    }

    public void topologicalSort(List<Node> graph) {
        System.out.println("Graph before DFS:");
        printGraph(graph);
        for (Node node : graph) {
            if (!node.isvisited) {
                depthFirstSearch(node);
            }
        }
        System.out.println("\nGraph after DFS:");
        printGraph(graph);
        System.out.println("Topological Sort (using DFS):");

        for (Node node : topologicalOrder) {
            System.out.print(node.data + " ");
        }

    }

    public void depthFirstSearch(Node node) {
        if (node.isvisited) {
            return;
        }
        node.discoverytime = time++;
        node.isvisited = true;
        for (Node neighbor : node.adjacenyList) {
            if (!neighbor.isvisited) {
                neighbor.discoverytime = time++;
                neighbor.parent = node;
                depthFirstSearch(neighbor);
            }

        }
        node.finishedtime = time++;
        topologicalOrder.add(node);

    }

    public void printGraph(List<Node> graph) {
        for (Node node : graph) {
            node.printAdjacencyList();
        }
    }

    public static void main(String[] args) {
        TopologicalSortGraph obj = new TopologicalSortGraph();
        Node node0 = obj.new Node(0);
        Node node1 = obj.new Node(1);
        Node node2 = obj.new Node(2);
        Node node3 = obj.new Node(3);

        // Define edges (directed graph)
        node0.adjacenyList.add(node1);
        node0.adjacenyList.add(node2);
        node1.adjacenyList.add(node3);
        node2.adjacenyList.add(node3);

        List<Node> graph = new ArrayList<>();
        graph.add(node0);
        graph.add(node1);
        graph.add(node2);
        graph.add(node3);

        // Perform topological sort
        obj.topologicalSort(graph);
    }

}
