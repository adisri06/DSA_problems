package DSA;

import java.util.Arrays;

public class PRismAlgorithmMST {
    public void primAlgo(int[][] graph){
        int vertices = graph.length;
        System.out.println("Vertices: "+vertices);
        boolean[] mstBool = new boolean[vertices];

        int key[] = new int[vertices];
        int parent[] = new int[vertices];
    //     //In Prim’s algorithm, we aim to find the vertex with the smallest edge weight connecting it to the MST.
	// •	//By default, the weight is set to a very high value (Integer.MAX_VALUE) so that any actual edge weight will be smaller and can replace this initial value.
        //Initializes all elements of the key array to Integer.MAX_VALUE.
        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] =0; // // Start from vertex 0
        parent[0]= -1;// Root of MST

        //•	A Minimum Spanning Tree for a graph with  n  vertices has exactly  n-1  edges (a tree property).
        //adding one edge to the MST in each iteration
        for (int count =0;count<vertices - 1;count++){
            // Pick the vertex with the smallest key value
            int u = minKey(key, mstBool);
            mstBool[u] = true;
                        // Update the key values of adjacent vertices
            for(int v=0;v<vertices;v++){
                if(graph[u][v]!=0 && !mstBool[v] && graph[u][v]<key[v])
                {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }

        }
       
        printMST(parent, graph);


    }
    public void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < graph.length; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }


    public int minKey(int[] key, boolean[] mstBool){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
       // •	v represents the current vertex being checked.
        for (int v=0;v < key.length;v++){
            //!mstBool[v]: The vertex is not yet included in the MST.
            if(!mstBool[v] && key[v]<min){
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
        PRismAlgorithmMST obj = new PRismAlgorithmMST();
        int[][] graph = {
            {0, 4, 25, 0, 0, 0, 0, 0, 9},  // Node 0
            {4, 0, 0, 1, 3, 0, 0, 0, 0},   // Node 1
            {25, 0, 0, 7, 0, 5, 0, 0, 0},  // Node 2
            {0, 1, 7, 0, 0, 0, 6, 0, 5},   // Node 3
            {0, 3, 0, 0, 0, 0, 0, 8, 0},   // Node 4
            {0, 0, 5, 0, 0, 0, 4, 0, 0},   // Node 5
            {0, 0, 0, 6, 0, 4, 0, 2, 0},   // Node 6
            {0, 0, 0, 0, 8, 0, 2, 0, 0},   // Node 7
            {9, 0, 0, 5, 0, 0, 0, 0, 0}    // Node 8
        };
        System.out.println("Graph Matrix:");
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
        obj.primAlgo(graph);
    }


}
