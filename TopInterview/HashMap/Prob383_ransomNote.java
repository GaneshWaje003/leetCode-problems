package TopInterview.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Prob383_ransomNote {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character , Integer> magazineMap = new HashMap<>();

        // storing letter frequencies 
        for(char c:magazine.toCharArray()){
            magazineMap.put(c , magazineMap.getOrDefault(c, 0) + 1);
        }

        // checking with ransomNote frequency 
        for(char c:ransomNote.toCharArray()){
            int count = magazineMap.getOrDefault(c, 0);
            if(count == 0 ) return false;
            magazineMap.put(c , count - 1);
        }

        return true;
    }
}
