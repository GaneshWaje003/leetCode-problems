import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem {
    public static void main(String[] args) {

        Problem obj = new Problem();
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        obj.rotate(nums, k);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public int maxProfit(int[] prices){

        // single iteratiosn 

        for(int i = 0 ;i < prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                return prices[i+1] - prices[i];
            }
        }

        return 0;
    }


}