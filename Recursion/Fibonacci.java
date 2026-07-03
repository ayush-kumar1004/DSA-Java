
public class Fibonacci {

    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int ans = fibonacci(num - 1) + fibonacci(num - 2);
        return ans;
    }

    public static void main(String[] args) {
        int fibNumtoCalculate = 6;
        System.out.print(fibonacci(fibNumtoCalculate));
    }
}
