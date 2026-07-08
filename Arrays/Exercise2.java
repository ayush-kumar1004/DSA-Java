
public class Exercise2 {

    public static void main(String[] args) {
        int arr[] = {3, 5, 4, 1, 9};
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.print("Min Value: " + min + " Max Value: " + max);
    }
}
