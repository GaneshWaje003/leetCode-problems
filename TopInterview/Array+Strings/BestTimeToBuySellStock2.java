public class BestTimeToBuySellStock2 {
    public static void main(String[] args) {
        int arrp[] = { 7, 1, 5, 3, 6, 4 };
        Solution s = new Solution();
        System.out.println(s.maxProfit(arrp));
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}