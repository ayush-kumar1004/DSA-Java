
/**
 * Time Complexity: O(num)
 * Explanation: The function sum(num) recursively calls sum(num - 1) until num reaches 1. 
 * This creates a total of num recursive steps. Each step executes in O(1) constant time, 
 * leading to a total time complexity of O(num).
 * 
 * Space Complexity: O(num)
 * Explanation: The recursion stack holds all active function frames. Since the depth of recursion 
 * is num (from num down to 1), the memory consumed on the call stack is O(num).
 */
public class Sum {

    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        int ans = num + sum(num - 1);
        return ans;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(sum(n));
    }
}
