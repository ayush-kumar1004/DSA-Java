
public class PrintSubarrays {

    public static void subArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = start; j < arr.length; j++) {
                int end = j;
                System.out.print("(");
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k]);
                    if (k < end) {
                        System.out.print(", ");
                    }
                }
                System.out.print(") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        subArray(arr);
    }
}
