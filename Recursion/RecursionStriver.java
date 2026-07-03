
public class RecursionStriver {

    public static void printNames(int num, String Name) {
        if (num == 0) {
            return;
        }
        System.out.println(Name);
        printNames(num - 1, Name);
    }

    public static void main(String[] args) {
        int n = 10;
        String name = "Ayush";
        printNames(n, name);

    }
}
