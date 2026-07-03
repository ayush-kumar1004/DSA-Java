
public class Sum {

    public static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        int ans = num + sum(num - 1);
        return ans;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(sum(n));
    }
}
