import java.util.*;

class DisjointSet {
    private int[] parent;

    // Constructor to initialize the Disjoint Set
    public DisjointSet(int n) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i; // Initially each element is its own parent
        }
    }

    // Find the parent of a node with path compression
    public int findParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findParent(parent[node]);  // Path compression
        return parent[node];
    }

    // Union two nodes u and v if their values are within the limit
    public void unionByVal(int u, int v, int limit, int[] nums) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (Math.abs(nums[v] - nums[u]) <= limit) {
            parent[pv] = pu;  // Union operation
        }
    }
}

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        if (nums.length == 1) {
            return nums;
        }

        int n = nums.length;
        DisjointSet dsu = new DisjointSet(n);

        // Step 1: Create a list of pairs (value, index)
        List<int[]> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(new int[]{nums[i], i});
        }

        // Step 2: Sort the array based on the values
        Collections.sort(v, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Union the consecutive elements in the sorted list
        for (int i = 0; i < n - 1; i++) {
            int[] p1 = v.get(i);
            int[] p2 = v.get(i + 1);
            dsu.unionByVal(p1[1], p2[1], limit, nums);
        }

        // Step 4: Group elements by their connected components
        Map<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.findParent(i);
            m.putIfAbsent(parent, new PriorityQueue<>());
            m.get(parent).offer(nums[i]);
        }

        // Step 5: Construct the result array
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int parent = dsu.findParent(i);
            ans[i] = m.get(parent).poll();
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Test case 1
        int[] nums1 = {3, 1, 2};
        int limit1 = 1;
        System.out.println("Test Case 1: " + Arrays.toString(solution.lexicographicallySmallestArray(nums1, limit1)));
        // Expected output: [1, 2, 3]

        // Test case 2
        int[] nums2 = {10, 15, 20, 25};
        int limit2 = 10;
        System.out.println("Test Case 2: " + Arrays.toString(solution.lexicographicallySmallestArray(nums2, limit2)));
        // Expected output: [10, 15, 20, 25] (No unions as the difference exceeds limit)

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        int limit3 = 2;
        System.out.println("Test Case 3: " + Arrays.toString(solution.lexicographicallySmallestArray(nums3, limit3)));
        // Expected output: [1, 2, 3, 4] (All elements are in one group and sorted)

        // Test case 4
        int[] nums4 = {4, 3, 2, 1};
        int limit4 = 1;
        System.out.println("Test Case 4: " + Arrays.toString(solution.lexicographicallySmallestArray(nums4, limit4)));
        // Expected output: [1, 2, 3, 4] (All elements are connected and sorted)

        // Test case 5
        int[] nums5 = {1, 4, 2, 5, 3};
        int limit5 = 3;
        System.out.println("Test Case 5: " + Arrays.toString(solution.lexicographicallySmallestArray(nums5, limit5)));
        // Expected output: [1, 2, 3, 4, 5] (Elements with differences <= 3 are connected and sorted)
    }
}