public class Prob67_addBinary {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.addBinary("11", "1");
    }
}

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result =new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry>0) {
            int sum = carry;

            if(i >=0 ) sum += a.charAt(i--)-'0';
            if(j >=0 ) sum += a.charAt(j--)-'0';



            result.append(sum%2);
            carry = sum / 2;

        }   

        return result.toString();
    }
}