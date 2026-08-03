
import java.util.*;

public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> s, int n) {
        if (s.isEmpty()) {
            s.push(n);
            return;
        }
        int data = s.pop();
        pushAtBottom(s, n);
        s.push(data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        pushAtBottom(s, 10);
        System.out.println(s);

    }
}
