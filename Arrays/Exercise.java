
import java.util.*;

public class Exercise {

    public static int arraylessthan(int[] arr, int find) {
        int si = 0;
        int ei = arr.length - 1;
        int mid = 0;
        while (si <= ei) {
            mid = si + (ei - si) / 2;
            if (arr[mid] <= find) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return si;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        
        int val = arraylessthan(arr, find);
        int arr2[] = new int[val];

        for (int i = 0; i < val; i++) {
            arr2[i] = arr[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}
