import java.nio.channels.IllegalChannelGroupException;
import java.util.ArrayList;
import java.util.List;

public class Prob66_plusOne {
    public static void main(String[] args) {
        int[] digit = { 1 , 9  , 2, 9 };
        int[] result = {};

        Solution s = new Solution();


        result = s.plusOne(digit);

        for (int i : result)
            System.out.print(i + " ");

    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse from the last digit backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // Add one and return immediately
                return digits;
            }
            digits[i] = 0;  // If digit is 9, set it to 0 and continue carry
        }

        // If we get here, all digits were 9 -> new array with leading 1
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}