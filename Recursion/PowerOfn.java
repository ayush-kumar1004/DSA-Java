
public class PowerOfn {

    // Normal Recursive Method
    public static int calPower(int n, int p) {
        if (p == 0) {
            return 1;
        }

        return n * calPower(n, p - 1);
    }

    // Optimized Recursive Method
    public static int calPowerOptimized(int n, int p) {
        if (p == 0) {
            return 1;
        }

        int halfPower = calPowerOptimized(n, p / 2);
        int halfPowerSq = halfPower * halfPower;

        if (p % 2 == 0) {
            return halfPowerSq;
        } else {
            return n * halfPowerSq;
        }
    }

    public static void main(String[] args) {
        int num = 2;
        int power = 10;

        System.out.println("Normal Recursion: " + calPower(num, power));
        System.out.println("Optimized Recursion: " + calPowerOptimized(num, power));
    }
}
