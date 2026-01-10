public class Prob3_longestSubString {
    public static void main(String[] args) {
        
        Solution s = new Solution();
        int result = s.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);

    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {

        StringBuilder sb = new StringBuilder();
        int largest = 0 ;
        
        for(int i =0;i<s.length();i++){
            
            // get current idx 
            char c = s.charAt(i);
            int idx = sb.indexOf(Character.toString(c));

            // check if 
            if(idx == -1){
                sb.append(c);
            }else{
                Math.max(largest , sb.length());
                sb.delete(0, idx+1);
                sb.append(c);
            }
        }

        largest = Math.max(largest , sb.length());
        
        return largest;
    }
}