public class Prob58_lengthOfLastWord {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "Hello World";
        System.out.println(obj.lengthOfLastWord(s));
    }

}

class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;

        s = s.trim();
        for(char c: s.toCharArray()){
            if(c == ' '){
                length = 0;
            }else{
                length++;
            }
        }

        return length;
    }
}