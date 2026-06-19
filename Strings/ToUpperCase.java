
public class ToUpperCase {

    public static String toUpperCase(String st) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(st.charAt(0)));
        for (int i = 1; i < st.length(); i++) {
            if (st.charAt(i) == ' ') {
                sb.append(st.charAt(i));
                i++;
                sb.append(Character.toUpperCase(st.charAt(i)));
            } else {
                sb.append(st.charAt(i));
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String st = "my name is ayush kumar.";
        System.out.println(toUpperCase(st));
    }

}
