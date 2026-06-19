
public class ShortestPath {

    public static double shortestPath(String str) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'S') {
                y--;
            }
            if (str.charAt(i) == 'E') {
                x++;
            }
            if (str.charAt(i) == 'W') {
                x--;
            }
        }
        double pathLength = Math.sqrt(x * x + y * y);
        return pathLength;
    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(shortestPath(str));
    }
}
