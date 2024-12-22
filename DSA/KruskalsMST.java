package DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Kruskal’s algorithm works by:
// 	1.	Sorting all edges by their weight.
// 	2.	Iterating over the sorted edges and adding them to the MST as long as they don’t form a cycle (using the Union-Find data structure to keep track of connected components).
// 	3.	Once you have vertices - 1 edges (in this case, 7 edges for 8 vertices), the MST is complete.


    public class KruskalsMST {
    //The Comparable interface allows objects of the Edge class to be compared to one another.
    // Implements Comparable to enable sorting edges by weight using Collections.sort().
    public class Edge implements Comparable<Edge>{
        int source;
        int destinaition;
        int weight;
        public Edge(int source, int destinaition, int weight){
            this.source = source;
            this.destinaition = destinaition;
            this.weight = weight;
        }

        public int compareTo(Edge otherEdge){
            return this.weight - otherEdge.weight;

        }

        
    }
    public class Subset{
        int parent;
        int rank;
    }
    public void minimalSpanningTrue(int[][] graph){
        int vertices = graph.length;
        System.out.println("Minimum Spanning Tree total verices:" + vertices);
        List<Edge> edges = new ArrayList<>();

        //converting matrix to edge list
        //Reason why we started from i+1 as
        // In an undirected graph, the adjacency matrix is symmetric. This means that if there is an edge between node i and node j, then graph[i][j] == graph[j][i].

        for (int i= 0;i< vertices;i++){
            for(int j = i+1;j<vertices;j++){
                if(graph[i][j]!=0){
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(edges);

        //Array of objects are created
        Subset[] subsets = new Subset[vertices];
        for (int i =0;i< vertices;i++){
            subsets[i]= new Subset();
            subsets[i].parent =i;
            subsets[i].rank = 0;
        }

        //Step 4 of Kruskal's algorithm
        List<Edge> mst = new ArrayList<>();
        int edgeCount = 0;
        for(Edge edge: edges){
            //As edges are always one less than number of vertices
            //If the number of edges is equal to the number of vertices, the MST is complete
            //If the number of edges is greater than the number of vertices, then there is a cycle in the graph
            if (edgeCount == vertices -1){
                break;

            }

            int rootSrc = find(subsets, edge.source);
            int rootDest = find(subsets, edge.destinaition);
            if(rootSrc != rootDest){
                mst.add(edge);
                edgeCount++;
                // Union the two sets
                if(subsets[rootSrc].rank < subsets[rootDest].rank){
                    subsets[rootSrc].parent = rootDest;
                }else if(subsets[rootSrc].rank > subsets[rootDest].rank){
                    subsets[rootDest].parent = rootSrc;
                }else{
                    subsets[rootDest].parent = rootSrc;
                    subsets[rootSrc].rank++;
                }

            }

        }

        System.out.println("Edges in MST:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.destinaition + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);


    }

    // find the “representative” or root of the set that the source element belongs to in the disjoint set (Union-Find) structure.
    public int find(Subset[] subsets, int source){

        // In the Union-Find data structure, nodes are grouped into sets, and the “root” of each set acts as the representative of the set.

        if(subsets[source].parent != source){
            //If the source node is not the root of its set (i.e., its parent is not the source itself), we call find recursively on the parent node of the source.
           //: The recursive call finds the root of the source node’s set and updates the parent of the source to point directly to the root. This “flattens” the tree structure and optimizes future lookups.
            subsets[source].parent = find(subsets, subsets[source].parent);
        }
        return subsets[source].parent;
    }
    public static void main(String[] args) {
        int[][] graph = {
            {4, 0, 2, 1, 0, 0, 0, 0, 0},  // Node 1
            {3, 2, 0, 0, 5, 0, 0, 0, 0},  // Node 2
            {0, 1, 0, 0, 6, 0, 0, 0, 0},  // Node 3
            {0, 0, 5, 6, 0, 7, 0, 0, 0},  // Node 4
            {0, 0, 0, 0, 7, 0, 8, 0, 0},  // Node 5
            {0, 0, 0, 0, 0, 8, 0, 9, 0},  // Node 6
            {0, 0, 0, 0, 0, 0, 9, 0, 10}, // Node 7
            {0, 0, 0, 0, 0, 0, 0, 10, 0}   // Node 8
        };
        KruskalsMST obj = new KruskalsMST();
        obj.minimalSpanningTrue(graph);
    }

}
