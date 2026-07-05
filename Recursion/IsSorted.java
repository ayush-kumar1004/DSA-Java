/**
 * Time Complexity: O(n)
 * Explanation: In the worst case (when the array is sorted), the function checks every adjacent pair 
 * of elements. For an array of size n, it makes n - 1 recursive checks. Each recursive check takes O(1) time. 
 * Therefore, the overall time complexity is O(n).
 * 
 * Space Complexity: O(n)
 * Explanation: The call stack size is proportional to the recursion depth, which goes up to n - 1 
 * in the worst case (for a fully sorted array). Hence, the space complexity is O(n).
 */
public class IsSorted {

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }

        return isSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Is array sorted: " + isSorted(arr, 0));
    }
}
