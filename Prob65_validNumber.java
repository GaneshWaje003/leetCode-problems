public class Prob65_validNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Ee";
        System.out.println(s.isNumber(str));
    }
}

class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        char ch  = ' ';

        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if(Character.isAlphabetic(ch) && s.charAt(i) != 'e' && s.charAt(i) != 'E'){
                return false;
            } 
        }

        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}