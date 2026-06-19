

public class BuyAndSellStocks {

    public static int buyAndSellStock(int arr[]) {
        int bP = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (bP < arr[i]) {
                int price = arr[i] - bP;
                maxProfit = Math.max(maxProfit, price);
            } else {
                bP = arr[i];

            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit Gained : " + buyAndSellStock(arr));
    }
}
