import java.util.ArrayList;
import java.util.List;

public class Prob93_restoreIpAddress {
    public static void main(String[] args) {

        Prob93_restoreIpAddress obj = new Prob93_restoreIpAddress();
        List<String> result = obj.restoreIpAddresses("25525511135");
        System.out.println(result);
    }

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        helper(s, 0, 0, new ArrayList<>());
        return result;
    }

    public void helper(String s, int start, int segCount, List<String> path) {

        // base case (string exausted )
        if (start == s.length() && segCount == 4) {
            result.add(String.join(".", path));
            return;
        }

        // pruning extra segments
        if (segCount >= 4 || start >= s.length()) {
            return;
        }

        // try segments len 1 , 2 , 3
        for (int len = 1; len <= 3; len++) {

            if (start + len > s.length()) break; // out of bounds

            String seg = s.substring(start, start + len);

            if (isValidSegment(seg)) {
                path.add(seg);
                helper(s, start + len, segCount + 1, path);
                path.remove((path.size() - 1)); // backtrack
            }

        }

    }

    private boolean isValidSegment(String seg) {
        if (seg.isEmpty() || seg.length() > 3) return false;

        // leading zero not allowed, except "0" itself
        if (seg.charAt(0) == '0' && seg.length() > 1)
            return false;

        int num = Integer.parseInt(seg);
        return num >= 0 && num <= 255;
    }

}

// rules

/*
 * 
 * 1) no leading 0 eg. 01
 * 2) ip should have 4 segments
 * 3) each seg range (0 , 255)
 * 4) seg length 1 to 3 digit
 * 
 */