

public class StaircaseSearch {

    public static boolean staircaseSearch(int arr[][], int key) {
        int row = 0;
        int col = arr[0].length - 1;
        while (col >= 0 && row < arr.length) {
            if (arr[row][col] == key) {
                System.out.println("Key Found at " + row + "," + col);
                return true;
            } else if (arr[row][col] < key) {
                row++;
            } else {
                col--;
            }
        }
        System.out.println("Not found");
        return false;

    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}};

        int key = 14;
        staircaseSearch(arr, key);
    }
}
