
import java.util.*;

public class CountSetBits {

    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) != 0) {
                count++;
            }
            num = num >> 1;

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        System.out.println("Total Set Bits in " + num + " is : " + countSetBits(num));
    }
}
