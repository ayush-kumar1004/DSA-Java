
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

    public static int update_ithBit(int num, int i, int newBit) {
        // Method 1: Using if-else
        // if (newBit == 0) {
        //     return clear_ithBit(num, i);
        // } else {
        //     return set_ithBit(num, i);
        // }

        // Alternate and Company Asked method
        num = clear_ithBit(num, i);
        int maskBit = (newBit << i);
        return num | maskBit;
    }

    public static int clearIBits(int num, int i) {
        int bitMask = (~0) << i;
        return num & bitMask;
    }

    // Clear all Bits from i to j (including i and j)
    public static int clearItoJBits(int num, int i, int j) {
        int a = (~0) << (j + 1);  //remeber 
        int b = (1 << i) - 1;     // doubt in this 
        int bitMask = a | b;
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
