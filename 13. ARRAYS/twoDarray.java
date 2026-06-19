
import java.util.*;

public class twoDarray {

    public static boolean search(int arr[][], int key) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Found at index : (" + i + "," + j + ")");
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = new int[3][3];
        int n = arr.length; // Number of Rows Horizontally
        int m = arr[0].length; // Number of Cols Vertically

        // Savinf the elements
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        //Printing 2d array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");;
            }
            System.out.println();
        }

        int key = 5;
        if (search(arr, key)) {
            System.out.println("Element is Present in array");
        } else {
            System.out.println("Element is not Present in array ");
        }

    }
}
