
public class BinarySearch {

    public static boolean BinarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 55;
        if (BinarySearch(arr, key) == false) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found ");
        }

    }
}
