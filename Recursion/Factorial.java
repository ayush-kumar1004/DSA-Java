
/**
 * Time Complexity: O(n)
 * Explanation: The function makes n recursive calls (factorial(num - 1) -> factorial(num - 2) ... -> factorial(1)),
 * and each call performs O(1) constant-time operations. Thus, the total time is proportional to num.
 *
 * Space Complexity: O(n)
 * Explanation: Due to the recursion stack. Each recursive call adds a frame to the call stack.
 * Since the recursion depth reaches n, the maximum space occupied on the stack is O(n).
 */
public class Factorial {

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        num = factorial(num - 1) * num;
        return num;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));

    }

}
