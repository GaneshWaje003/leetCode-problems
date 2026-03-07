package TopInterview.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Prob290_wordPattern {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        Map<Character , String> charToWord = new HashMap<>();
        Map<String,Character> wordToChar = new HashMap<>();
        
        for(int i = 0 ; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            String sh = words[i];

            if(charToWord.containsKey(ch)){
                if(!charToWord.get(ch).equals(sh)) return false;
            }else{
                charToWord.put(ch , sh);
            }

            if(wordToChar.containsKey(sh)){
                if(wordToChar.get(sh) != (ch)) return false;
            }else{
                wordToChar.put(sh , ch);
            }
        }

        return true;
    }
}
