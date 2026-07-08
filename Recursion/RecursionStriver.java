
/**
 * Time Complexity: O(num)
 * Explanation: The function printNames prints the name once and calls itself with num - 1. 
 * This recurses exactly num times until num == 0. Each call executes in O(1) time (ignoring string copying / large outputs), 
 * leading to a total time complexity of O(num).
 * 
 * Space Complexity: O(num)
 * Explanation: Due to the recursion stack. Since there are num recursive steps, the call stack will 
 * have a maximum depth of num active frames, resulting in O(num) space complexity.
 */
public class RecursionStriver {

    public static void printNames(int num, String Name) {
        if (num == 0) {
            return;
        }
        System.out.println(Name);
        printNames(num - 1, Name);
    }

    public static void main(String[] args) {
        int n = 10;
        String name = "Ayush";
        printNames(n, name);

    }
}
