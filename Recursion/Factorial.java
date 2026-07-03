
public class Factorial {

    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        num = factorial(num - 1) * num;
        return num;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(factorial(n));

    }

}
