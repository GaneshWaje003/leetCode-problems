package TopInterview.TwoPointers;

public class Prob_125_validPalindrome {
    public static void main(String[] args) {
        
    }
}


class Solution {
    public boolean isPalindrome(String s) {

        String cleaned = s.toLowerCase().trim().replaceAll("[^a-z0-9]", "");

        int left = 0 , right = cleaned.length()-1 , n = cleaned.length() -1 ;


        while(left < right){
            if(cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}