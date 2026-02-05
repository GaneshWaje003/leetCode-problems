public class Prob69_sqrt {
   public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.mySqrt(8));
   } 
}

class Solution {

    // newton and raphson formula 

    public int mySqrt(int x) {

        if(x == 0 || x == 1) return x;
        
        double xi = x / 2 ; // init guess
        double root = 1;    // storing each iteration value
        double tolerance = 1e-6;  // checking if the root -x is < tolerance then root is found


        while(true){
            root = 0.5 * (xi + x / xi);         // finding value at each iteration

            // check if value is < tolerance
            if(Math.abs(root - xi) < tolerance) break;

            xi = root;

        }

        return (int) root;

    }
}