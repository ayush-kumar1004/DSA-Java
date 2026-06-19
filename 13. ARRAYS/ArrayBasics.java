
import java.util.Scanner;

public class ArrayBasics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int j = 1;
        int arr[] = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = j;
            j++;
        }
        for (int i = 0; i < 50; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
