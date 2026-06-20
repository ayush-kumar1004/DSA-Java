
import java.util.*;

public class PowerOfTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int num = sc.nextInt();

        int ans = num & (num - 1);

        if (ans == 0) {
            System.out.println(num + " is a Power of Two");
        } else {
            System.out.println(num + " is not a Power of Two");
        }
    }
}
