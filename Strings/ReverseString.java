
public class ReverseString {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        String arr[] = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String original = arr[i];
            String reversed = "";
            if (i % 2 == 0) {
                for (int j = arr[i].length() - 1; j >= 0; j--) {
                    reversed += original.charAt(j);
                }
                sb.append(reversed);
                sb.append(" ");
            } else {
                sb.append(arr[i]);
                sb.append(" ");

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "my name is XYZ";
        System.out.println(reverseString(str));
    }
}
