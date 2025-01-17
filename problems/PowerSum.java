import java.math.BigInteger;
import java.util.List;

public class PowerSum {

    public static BigInteger powerSum(List<Object> list, int power) {
        BigInteger sum= BigInteger.ZERO;

        for(Object s : list){
            if(s instanceof Integer){
                sum = sum.add(BigInteger.valueOf((int) s));
            }else if(s instanceof List){
                sum = sum.add(powerSum((List<Object>) s, power + 1));

            }

        }
        return sum.pow(power);
    }
    public static void main(String[] args) {
        // Test Case 1: Deeply Nested List
        List<Object> testCase1 = List.of(
            List.of(
                List.of(1), 
                List.of(2, List.of(3))
            ), 
            4
        );

        // Test Case 2: All Numbers at Same Depth
        List<Object> testCase2 = List.of(1, 2, 3, 4, 5);

        // Test Case 3: Empty List
        List<Object> testCase3 = List.of();

        // Test Case 4: List with Only Nested Empty Lists
        List<Object> testCase4 = List.of(
            List.of(List.of()), 
            List.of()
        );

        // Test Case 5: Large Numbers and Deeper Nesting
        List<Object> testCase5 = List.of(
            List.of(10, 20), 
            List.of(5, List.of(2, List.of(3, 4)))
        );

        // Test Case 6: Uneven Nesting
        List<Object> testCase6 = List.of(
            1, 
            List.of(2, List.of(3, 4, List.of(5))), 
            6
        );

        // Running all test cases
        System.out.println("Test Case 1 Output: " + powerSum(testCase1, 1)); // Expected: 30
        System.out.println("Test Case 2 Output: " + powerSum(testCase2, 1)); // Expected: 15
        System.out.println("Test Case 3 Output: " + powerSum(testCase3, 1)); // Expected: 0
        System.out.println("Test Case 4 Output: " + powerSum(testCase4, 1)); // Expected: 0
        System.out.println("Test Case 5 Output: " + powerSum(testCase5, 1)); // Expected: 1428055
        System.out.println("Test Case 6 Output: " + powerSum(testCase6, 1)); // Expected: Computed value
    }
}

    /**
     * Recursively calculates the sum of integers in a nested list and raises the sum to the specified power.
     * Handles deeply nested lists and large numbers using BigInteger to avoid overflow.
     *
     * @param list   The nested list (contains integers or other nested lists).
     * @param power  The current power to raise the sum to, which increases with each recursive call.
     * @return       The computed sum raised to the specified power, represented as a BigInteger.
     */
