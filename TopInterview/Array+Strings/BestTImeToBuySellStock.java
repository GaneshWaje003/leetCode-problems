public class BestTImeToBuySellStock {
    public static void main(String[] args) {
        int arrp[] = {7,1,5,3,6,4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(arrp));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0 ;


        for(int i = 0 ;i < prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0 ;


        for(int i = 1 ; i< prices.length;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}