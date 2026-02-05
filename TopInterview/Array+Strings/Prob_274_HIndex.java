import java.util.Arrays;

public class Prob_274_HIndex {
    public static void main(String[] args) {
        int[] arr = {3 , 0 , 6, 1 , 5}; // 0 , 1 , 3  , 5 , 6 
        Solution s = new Solution();
        int hIndx = s.hIndex(arr);
        System.out.println(hIndx);
    }
}

class Solution {
    public int hIndex(int[] citations) {
        

        Arrays.sort(citations);

        int n = citations.length;
        int h = 0 ;


        for (int i = n-1; i >= 0; i--) {
            if(citations[i] >=  n-i){
                h = n - i ;
            }else{
                break;
            }
        }

    
        return h;
    }
}