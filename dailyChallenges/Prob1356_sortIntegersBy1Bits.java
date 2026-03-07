import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1356_sortIntegersBy1Bits {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] arr1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] result1 = sol.sortByBits(arr1);
        System.out.println("Expected: [0,1,2,4,8,3,5,6,7] → " + Arrays.toString(result1));

    }
}

class Solution {
    public int[] sortByBits(int[] arr) {

        Integer[] boxed = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            boxed[i] = arr[i];
        }

        Arrays.sort(boxed, (a, b) -> {
            int bitsA = Integer.bitCount(a.intValue());
            // System.out.println(bitsA);
            int bitsB = Integer.bitCount(b.intValue());
            // System.out.println(bitsB);
            System.out.println(bitsA + " " + bitsB+"------------------" + a + " " + b);
            return bitsA == bitsB ? a - b : bitsA - bitsB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }

        return arr;
    }
}