import java.util.Arrays;

public class Prob72_editDistance {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.minDistance("worqd", "wordzzp"));

    }
}

class Solution {

    public int helper(String word1, String word2, int i, int j, int[][] dp) {
        // base case

        // base case if word1 is exausted me must add remaining of word 2
        if (i == word1.length()) {
            return word2.length() - j;
        }

        // word2 is exausted we must delete remaining chars of the word1
        if (j == word2.length()) {
            return word1.length() - i;
        }

        // recursion
        char a = word1.charAt(i);
        char b = word2.charAt(j);

        // checking if value is not null then returning stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result;
        if (a == b) {
            return 0 + helper(word1, word2, i + 1, j + 1, dp); // if string matched
        } else {
            int insert = helper(word1, word2, i, j + 1, dp); // follwoing start insertion
            int delete = helper(word1, word2, i + 1, j, dp); // follwoing start deletion
            int replace = helper(word1, word2, i + 1, j + 1, dp); // follwoing start replacement

            // storing result as insert and other are local vars
            result = 1 + Math.min(insert, Math.min(delete, replace));
        }

        dp[i][j] = result; // storing result in dp for avoid retundent cost finding

        return result;
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        
        // Correct way to fill a 2D array
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int result = helper(word1, word2, 0, 0, dp);

        return result;
    }
}
