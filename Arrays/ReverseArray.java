
public class ReverseArray {

    public static void reverseArray(int arr[]) {
        int f = 0;
        int l = arr.length - 1;
        while (f < l) {
            int temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;

        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 23, 123, 5, 6, 67, 27, 55};
        reverseArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
