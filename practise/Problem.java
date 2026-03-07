import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.canConstruct("aa", "ab"));

    }

    public boolean isPrime(int num){
        
        // ? for negative numbers & o and 1 
        if(num <= 1) return false;

        for(int i = 2 ; i * i <= num ;i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;

    }

}









class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character , Integer> seen = new HashMap<>();
        for(char c : magazine.toCharArray()){
            seen.put( c , seen.getOrDefault(c, 0) + 1);
        }

        // check and consume ransomnote
        for(char c :ransomNote.toCharArray()){
            int count = seen.getOrDefault(c, 0);
            if(count == 0) return false;
            seen.put(c , count -1 );
        }

        return true;
    }
}
