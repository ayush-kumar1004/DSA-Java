
/**
 * Time Complexity: O(num)
 * Explanation: The function printDec prints the current number and calls itself with num - 1 recursively. 
 * This sequence of recursive calls executes num times (from num down to 1). Each call takes O(1) time. 
 * Thus, the overall time complexity is O(num).
 * 
 * Space Complexity: O(num)
 * Explanation: Each recursive call adds a frame to the execution stack. With a recursion depth of num, 
 * the stack space required is O(num).
 */
public class Recurssion1 {

    public static void printDec(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        }
        System.out.print(num + " ");
        printDec(num - 1);
    }

    public static void main(String[] args) {
        int num = 10;
        printDec(num);
    }
}
