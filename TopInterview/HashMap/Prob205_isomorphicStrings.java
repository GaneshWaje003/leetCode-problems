package TopInterview.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Prob205_isomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        
        for(int i = 0 ; i < s.length();i++){
            
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if(sMap.containsKey(sc) && sMap.get(sc) != tc){
                return false;
            }

            if(tMap.containsKey(tc) && tMap.get(tc) != sc){
                return false;
            }

            sMap.put(sc , tc);
            tMap.put(tc , sc);

        }

        return true;

    }
}
