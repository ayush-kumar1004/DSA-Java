
public class Recurssion2 {

    public static void printInc(int num) {
        if (num == 1) {
            System.out.print(num + " ");
            return;
        }
        printInc(num - 1);
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        int num = 10;
        printInc(num);
    }
}
