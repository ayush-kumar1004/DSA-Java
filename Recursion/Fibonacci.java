
/**
 * Time Complexity: O(2^n)
 * Explanation: Each call to fibonacci(num) branches into two recursive calls: fibonacci(num - 1) 
 * and fibonacci(num - 2). This creates a recursion tree of height n. The total number of nodes 
 * in a full binary tree of height n is 2^(n+1) - 1, which grows exponentially as O(2^n).
 * 
 * Space Complexity: O(n)
 * Explanation: The space complexity is determined by the maximum depth of the recursion tree (call stack). 
 * At any point in time, the stack will hold at most n active stack frames, so the space complexity is O(n).
 */
public class Fibonacci {

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int ans = fibonacci(num - 1) + fibonacci(num - 2);
        return ans;
    }

    public static void main(String[] args) {
        int fibNumtoCalculate = 23;
        System.out.print(fibonacci(fibNumtoCalculate));
    }
}
