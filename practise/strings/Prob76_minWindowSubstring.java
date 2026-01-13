import java.util.HashMap;
import java.util.Map;

public class Prob76_minWindowSubstring {
    public static void main(String[] args) {

        Solution obj = new Solution();
        String s = "ADOBECODEBANC", t = "ABC";
        obj.minWindow(s, t);

    }
}

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        // frequency map
        Map<Character, Integer> required = new HashMap<>();
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        // frequency map for windows
        Map<Character, Integer> window = new HashMap<>();
        int have = 0; // no. of chars matched
        int need = required.size();

        // track min window
        String minWindow = "";
        int left = 0, right = 0;

        // traversing
        while (right < s.length()) {

            // expand right
            char c1 = s.charAt(right);
            window.put(c1, window.getOrDefault(c1, 0) + 1);

            // check if this char is required and now satisfied
            if (required.containsKey(c1) && window.get(c1).equals(required.get(c1))) {
                have++;
            }

            // try to contract left

            while (left <= right && have == need) {

                // getting left char
                char lchar = s.charAt(left);


                // updated min window 
                String curr = s.substring(left, right +1);
                if(minWindow.isEmpty() || curr.length() < minWindow.length()){
                    minWindow = curr;
                }


                // shrink from lef
                window.put(lchar, window.get(lchar) - 1);
                if(required.containsKey(lchar) && window.get(lchar) < required.get(lchar)){
                    have--;
                }

                left++;
            }

            right++;

        }

        return minWindow;

    }
}
