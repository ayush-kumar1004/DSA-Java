// Brute Force method Tc = O(n^3);

// public class MaxSubarraySum {
//     public static int subArraySum(int arr[]) {
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;
//         for (int i = 0; i < arr.length; i++) {
//             int start = i;
//             for (int j = start; j < arr.length; j++) {
//                 int end = j;
//                 currSum = 0;
//                 for (int k = start; k <= end; k++) {
//                     currSum += arr[k];
//                     if (maxSum < currSum) {
//                         maxSum = currSum;
//                     }
//                 }
//             }
//         }
//         return maxSum;
//     }
//     public static void main(String[] args) {
//         int arr[] = {1, -2, 3, 4, 5, -6};
//         System.out.println("Max Sum Of the array : " + subArraySum(arr));
//     }
// }
// Optimize Approach (Prefix Sum) Tc = O(n^2);
public class MaxSubarraySum {
    public static int subArraySumPrefixArray(int arr[]) {
        int currSum = 0;
        int prefixArr[] = new int[arr.length];
        int maxSum = Integer.MIN_VALUE;
        prefixArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixArr[i] = prefixArr[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                if (start == 0) {
                    currSum = prefixArr[end];
                } else {
                    currSum = prefixArr[end] - prefixArr[start - 1];
                }
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {1, -2, 3, 4, 5, -6};
        System.out.println("Max Sum Of the array : " + subArraySumPrefixArray(arr));
    }
}
// Max Subarray More optimized Approach (Kadane's Algo) Tc = O(n);
// public class MaxSubarraySum {

//     public static int Kadanes(int arr[]) {
//         int cs = 0;
//         int ms = Integer.MIN_VALUE;
//         for (int i = 0; i < arr.length; i++) {
//             cs += arr[i];
//             if (cs < 0) {
//                 cs = 0;
//             }
//             if (cs > ms) {
//                 ms = cs;
//             }
//         }

//         return ms;
//     }

//     public static void main(String[] args) {
//         int arr[] = {1, -2, 3, 4, 5, -6};

//         System.out.println("Max Sum Of the array : " + Kadanes(arr));
//     }
// }
