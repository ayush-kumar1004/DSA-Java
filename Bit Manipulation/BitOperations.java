
public class BitOperations {

    public static void get_ithBit(int num, int i) {
        int bitMask = 1 << i;
        if ((num & bitMask) == 0) {
            System.out.println("Bit is 0");
        } else {
            System.out.println("Bit is 1");
        }
    }

    public static int set_ithBit(int num, int i) {
        int bitMask = 1 << i;
        return num | bitMask;

    }

    public static int clear_ithBit(int num, int i) {
        int bitMask = ~(1 << i);
        return num & bitMask;
    }

    public static void main(String[] args) {
        int num = 10;
        int i = 2;
        int j = 1;
        get_ithBit(num, i);
        System.out.println(set_ithBit(num, i));
        System.out.println(clear_ithBit(num, j));

    }
}
