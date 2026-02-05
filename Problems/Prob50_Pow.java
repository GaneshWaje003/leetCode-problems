public class Prob50_Pow {
    public static void main(String[] args) {
        Solution s = new Solution();
        double x = 2.00000;
        int n = 4;
        System.out.println(s.myPow(x, n));
    }
}

class Solution {
    public double myPow(double x, int n) {
        long exp = n ;

        if(exp < 0){
            exp = -exp;
            x = 1 / x;
        }
        double result = 1.0;

        while(exp > 0){
            if(exp % 2 == 1){
                result = result * x;
            }

            x = x * x;
            exp = exp / 2;
        }

        return result;
    }
}
