
public class Sorting {

    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int swap = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if (swap == 0) {
                break;
            }
        }
    }

    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {7, 8, 3, 1, 2};
        // bubbleSort(arr);
        selectionSort(arr);
        printArr(arr);
    }
}
