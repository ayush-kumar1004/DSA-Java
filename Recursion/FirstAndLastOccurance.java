/**
 * Time Complexity: O(n)
 * Explanation: In the worst case (e.g. if the key is at the last index or not present in the array), 
 * the methods firstOccurance and lastOccurance will recursively check every element in the array of size n. 
 * Since each call does O(1) work, the total time is O(n).
 * 
 * Space Complexity: O(n)
 * Explanation: Due to the recursion stack depth. In the worst case, the function recurses n times 
 * (from index 0 up to arr.length), resulting in a call stack of depth n, which takes O(n) memory.
 */
public class FirstAndLastOccurance {
    public static int firstOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

    public static int lastOccurance(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 8, 7, 3, 4, 8, 7, 6, 9 };
        int key = 8;
        System.out.println("First Occurance: " + firstOccurance(arr, key, 0));
        System.out.println("Last Occurance: " + lastOccurance(arr, key, 0));
    }
}