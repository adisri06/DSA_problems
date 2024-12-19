package DSA;

// •	Influencer Grouping: This approach can help social media platforms identify strongly connected influencer groups where each influencer is interlinked with others, which can be used for marketing or recommendation systems.
// •	Community Detection: Identifying tightly-knit communities in a social network where users have mutual influence over each other.
// •	Content Recommendation: If two users belong to the same SCC, they likely have a high mutual interest in certain topics, so the platform might recommend each other’s content.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class KosarajuStronglyConnectedAlgorithm {
    public int time = 0;              // To track the discovery and finish time during DFS.
    class Node {
        int data;               // Node value (e.g., 1, 2, 3)
        boolean isVisited;      // Track whether the node has been visited
        Node parent;            // Parent node in the DFS tree
        int discoveryTime;      // Discovery time during DFS
        int finishedTime;       // Finish time during DFS
        List<Node> adjacencyList;  // List of neighbors (edges)

        // Constructor to initialize a node
        public Node(int data) {
            this.data = data;
            this.isVisited = false;
            this.parent = null;
            this.discoveryTime = -1;
            this.finishedTime = -1;
            this.adjacencyList = new ArrayList<>();
        }

        // Add a neighbor to the adjacency list
        public void addNeighbor(Node neighbor) {
            this.adjacencyList.add(neighbor);
        }
    }
    class Graph {
        private Map<Integer, Node> nodes = new HashMap<>();

        // Add an edge between two nodes
        public void addedge(int source, int destination) {
            Node sourceNode = nodes.computeIfAbsent(source, key -> new Node(source));
            Node destinationNode = nodes.computeIfAbsent(destination, key -> new Node(destination));
            sourceNode.addNeighbor(destinationNode);
        }

        // Perform Kosaraju's algorithm to find SCCs
        public List<List<Integer>> kosaraju() {
            List<List<Integer>> sccs = new ArrayList<>();
            Stack<Node> stack = new Stack<>();

            // First DFS pass: Fill the stack with nodes in finish time order
            for (Node node : nodes.values()) {
                if (!node.isVisited) {
                    dfs(node, stack);
                }
            }

            // Reverse the graph
            Graph reversedGraph = reverseGraph();

            // Reset visited status for the second DFS pass
            for (Node node : reversedGraph.nodes.values()) {
                node.isVisited = false;
            }

            // Second DFS pass: Process nodes in order of finish time (stack order)
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (!node.isVisited) {
                    List<Integer> scc = new ArrayList<>();
                    reversedGraph.dfsforscc(node, scc);
                    sccs.add(scc);  // Add the SCC to the result list
                }
            }

            return sccs;
        }

        // Reverse the graph (reverse all edges)
        public Graph reverseGraph() {
            Graph reversedGraph = new Graph();
            for (Node node : nodes.values()) {
                for (Node neighbor : node.adjacencyList) {
                    reversedGraph.addedge(neighbor.data, node.data);
                }
            }
            return reversedGraph;
        }

        // DFS method for the first pass to fill the stack
        public void dfs(Node node, Stack<Node> stack) {
            node.isVisited = true;
            node.discoveryTime = time++;

            // Visit all neighbors
            for (Node neighbor : node.adjacencyList) {
                if (!neighbor.isVisited) {
                    neighbor.parent = node;
                    dfs(neighbor, stack);
                }
            }

            node.finishedTime = time++;
            stack.push(node);  // Add the node to the stack after finishing
        }

        // DFS method for the second pass to find SCCs
        public void dfsforscc(Node node, List<Integer> scc) {
            node.isVisited = true;
            scc.add(node.data);  // Add the node to the current SCC

            // Visit all neighbors
            for (Node neighbor : node.adjacencyList) {
                if (!neighbor.isVisited) {
                    dfsforscc(neighbor, scc);
                }
            }
        }

        // Find the Maximum SCC (MSCC)
        public List<Integer> findMaximumSCC(List<List<Integer>> sccs) {
            List<Integer> maxSCC = new ArrayList<>();
            for (List<Integer> scc : sccs) {
                if (scc.size() > maxSCC.size()) {
                    maxSCC = scc;
                }
            }
            return maxSCC;
        }
    }
    
public static void main(String[] args) {
    KosarajuStronglyConnectedAlgorithm obj = new KosarajuStronglyConnectedAlgorithm();
    Graph g = obj.new Graph();
    // Add edges based on the example graph
    g.addedge(1, 2);
    g.addedge(2, 3);
    g.addedge(3, 4);
    g.addedge(4, 5);
    g.addedge(5, 2);  // This creates a cycle (2 -> 3 -> 4 -> 5 -> 2)
    
    g.addedge(6, 7);
    g.addedge(7, 8);
    g.addedge(8, 9);
    g.addedge(9, 6);  // This creates another cycle (6 -> 7 -> 8 -> 9 -> 6)

    List<List<Integer>> result = g.kosaraju();
     // Print all SCCs
   // Print all SCCs
   System.out.println("Strongly Connected Components (SCCs):"+ result.size());

   for (int i = 0; i < result.size(); i++) {
       System.out.print("SCC " + (i + 1) + ": ");
       System.out.println(result.get(i).toString());
   }
   
   // Find and print the Maximum SCC (MSCC)
   List<Integer> mscc = g.findMaximumSCC(result);
   System.out.print("\nMaximum SCC (MSCC): ");
   System.out.println(mscc.isEmpty() ? "No SCC found" : mscc);
}

}
