public class Prob44_wildcardMatching {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a"))
        ;s.isMatch("aab", "a*");
    
        // String a = "aa";
        // System.out.println(a.length()-1);
    
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        
        int j = 0 ,i = 0 , strIdx = -1 , match = 0;


        while(i < s.length()){

            if(j<p.length() && (p.charAt(j) == '?' || p.charAt(j) ==  s.charAt(i))){
                i++; j++;
            }else if(j < p.length() && p.charAt(j) == '*'){
                strIdx = j;
                match = i;
                j++;
            }else if(strIdx != -1){
                j = strIdx+1;
                match++;
                i = match;
            }else{
                return false;
            }

        }

        while( j<p.length() && p.charAt(j) == '*'){
            j++;
        }

        return j == p.length();
        }
}