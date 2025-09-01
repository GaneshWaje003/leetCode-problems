public class prob38_countAndSay {
    public static void main(String[] args) {        
        Solution s = new Solution();
        System.out.println(s.countAndSay(4));
    }
}


class Solution {
    
    public String encode(String s){
        String result = "";
        int count = 1;

        for(int i=0;i<s.length();i++){
            while(i+1< s.length() && s.charAt(i) == s.charAt(i+1)){
                count++;
                i++;
            }

            result += Integer.toString(count)+s.charAt(i);
            count = 1;
        }


        return result;
    }
    
    public String countAndSay(int n) {

        if (n==1) return "1";

        return encode(countAndSay(n-1));
    }
}