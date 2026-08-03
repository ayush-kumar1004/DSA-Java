
import java.util.*;
// Implementation of stack using ArrayList

public class Stack1 {

    static class Stack {

        public static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            if (list.size() == 0) {
                return true;
            }
            return false;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        //peek
        public static int peek() {
            int top = list.get(list.size() - 1);
            return top;
        }

    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }

}
