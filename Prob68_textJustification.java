import java.util.ArrayList;
import java.util.List;

public class Prob68_textJustification {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        solution.fullJustify(words, 16);
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder sb = new StringBuilder();

            if (j == words.length || gaps == 0) {  // last line or single word case
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                int trailingSpaces = maxWidth - sb.length();
                sb.append(" ".repeat(trailingSpaces));  // pad right side
            } else {
                int totalSpaces = maxWidth - (lineLength - gaps);
                int evenSpaces = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;

                for (int k = i; k < j - 1; k++) {
                    sb.append(words[k]);
                    sb.append(" ".repeat(evenSpaces + (k - i < extraSpaces ? 1 : 0)));
                }
                sb.append(words[j - 1]);
            }

            ans.add(sb.toString());
            i = j;
        }

        return ans;
    }
}
