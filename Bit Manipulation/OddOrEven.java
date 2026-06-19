
import java.util.*;

public class OddOrEven {

    public static void oddEven(int num) {
        int bitMask = 1;
        if ((num & bitMask) == 0) {
            System.out.println("Number is Even ");
        } else {
            System.out.println("Number is Odd ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number you want to check : ");
        int num = sc.nextInt();
        oddEven(num);

    }
}
