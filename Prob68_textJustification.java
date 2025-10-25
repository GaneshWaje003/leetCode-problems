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

        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");

        temp.append(words[0] + " ");
        for (int i = 1; i < words.length; i++) {

            if ((temp.length() + words[i].length()) <= maxWidth) {
                temp.append(words[i] + " ");
            } else {
                // deleting last space
                temp.deleteCharAt(temp.length() - 1);

                // adding item to result
                result.add(temp.toString());

                // reseting builder
                temp.setLength(0);

                // appending current word
                temp.append(words[i] + " ");
            }

        }

        result.add(temp.toString());
        
        for(int i=0;i<result.size();i++){
            String[] parts = result.get(i).split(" ");
            int wordsCount = parts.length;
            int totalChars = 0;

            for(String child:parts) totalChars+=child.length();

            int spaces = maxWidth - totalChars;
            StringBuilder sb = new StringBuilder();

            if(wordsCount == 1 || i == result.size()-1){
                sb.append(String.join(" ", parts));
            }else{

                int evenSpaces = spaces / 2;
                int extraSpaces = spaces % 2;
                
                for(int j=0;j<parts.length;j++){
                    sb.append(parts[j]);
                    if( j < parts.length-1){
                        int spaceCount = evenSpaces + ( j < extraSpaces ? 1:0);
                        sb.append(" ".repeat(spaceCount));
                    }
                    
                }
                
            }
            result.set(i , sb.toString());

        }

        return result;
    }
}