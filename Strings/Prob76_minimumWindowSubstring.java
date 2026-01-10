import java.util.HashMap;
import java.util.Map;

public class Prob76_minimumWindowSubstring {
    public static void main(String[] args) {

    }
}

class Solution {
    public String minWindow(String s, String t) {

        int sIndex = -1;
        int count = 0;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int required = freqMap.size();
        int formed = 0;
        Map<Character, Integer> windowMap = new HashMap<>();

        int right = 0, left = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (freqMap.containsKey(c) && windowMap.get(c).equals(freqMap.get(c))) {
                formed++;
            }
            
            while(left <=right && formed == required){
                c = s.charAt(left);

                if(right-left+1 < minLen){
                    minLen = right - left +1;
                    sIndex = left;
                }

            }   
        }

        return "";
    }
}