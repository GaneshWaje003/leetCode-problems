import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Problem {
    public static void main(String[] args) {

        Problem obj = new Problem();
        int[] arr = { 3, 2, 4 };

    }

    public int lengthOfLongestSubstring(String s) {
        
        int max = 0  ;
        int right = 0  , left = 0 ; 

        HashSet<Character> charSet = new HashSet<>();

        for (right = 0; right < s.length(); right++) {
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            max = Math.max(max , right - left + 1);
        }


        return max;
    }

    public boolean isDuplicatePresent(int[] arr){
        HashSet<Integer> arrSet = new HashSet<>();

        for(int i :arr){
            
            if(arrSet.contains(i)){
                return true;
            }

            arrSet.add(i);
        }

        return false;
    }

    public char firstUnique(String s){
        HashMap<Character,Integer> charFreq = new HashMap<>();

        for(char c:s.toCharArray()){
            charFreq.put(c ,charFreq.getOrDefault(c, 0)+1);
        }

        for(char c:s.toCharArray()){
            if(charFreq.get(c) == 1){
                return c;
            }
        }

        return '_';
    }

    public int[] twoSum(int[] arr , int target){

        HashMap<Integer , Integer> IntFreq = new HashMap<>();

        for(int i = 0 ; i <arr.length ;i++){

            int comp = target - arr[i];

            if(IntFreq.containsKey(comp)){
                return new int[]{IntFreq.get(comp) , i};
            }

            IntFreq.put(arr[i] , i);
        }

        return new int[]{};
    }

    // public int[] intersection()
}
