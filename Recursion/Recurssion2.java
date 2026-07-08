
/**
 * Time Complexity: O(num)
 * Explanation: The function printInc makes a recursive call printInc(num - 1) before printing the number. 
 * This creates a chain of num recursive calls (from num down to 1). Since each step runs in constant O(1) time, 
 * the total time complexity is O(num).
 * 
 * Space Complexity: O(num)
 * Explanation: The recursion calls build up a stack of depth num before starting to unwind and print. 
 * This requires O(num) space on the recursion call stack.
 */
public class Recurssion2 {

    public static void printInc(int num) {
        if (num == 1) {
            System.out.print(num + " ");
            return;
        }
        printInc(num - 1);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        int num = 10;
        printInc(num);
    }
}
