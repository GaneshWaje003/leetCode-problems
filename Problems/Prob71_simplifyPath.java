import java.util.Deque;
import java.util.LinkedList;

public class Prob71_simplifyPath {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("..//.."));
    }
}

class Solution {
    public String simplifyPath(String path) {

        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String i : components) {
            if (i.equals("") || i.equals("."))
                continue;
            else if (i.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                stack.offerLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String dir :stack){
            sb.append("/").append(dir);
        }


        return sb.length() == 0 ? "/" : sb.toString();

    }
}