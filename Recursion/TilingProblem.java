
public class TilingProblem {
// this is for 2*n tiling problem using 2*1 tiles

    public static int tilingProblem(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int vertical = tilingProblem(n - 1);
        int horizontal = tilingProblem(n - 2);
        return vertical + horizontal;
    }
// this is for 4*n tiling problem using 4*1 tiles

    public static int tilingProblemfor4(int n) {
        if (n < 4) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        int vertical = tilingProblemfor4(n - 1);
        int horizontal = tilingProblemfor4(n - 4);
        return vertical + horizontal;
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println(tilingProblem(num));
        System.out.println(tilingProblemfor4(num));

    }
}
