
import java.util.*;

public class PalindromeCheck {

    public static boolean palindromeCheck(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string you want to check : ");
        String str = sc.nextLine();
        System.out.println(palindromeCheck(str));
    }
}
