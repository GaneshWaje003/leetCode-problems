import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob49_groupAnagrams {
    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution s = new Solution();
        System.out.println(s.groupAnagrams(input));
    }
}

class Solution1 {

    public boolean areAnagrams(String str1 , String str2){

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        String str1 , str2 = "";

        for (int i = 0; i < strs.length; i++) {
            str1 = strs[i];
            if(visited[i] == false) {
                visited[i] = true;
                temp.add(str1);
            }

            for (int j = 0; j < strs.length; j++) {
                if(i == j) continue;
                str2 = strs[j];
                if(areAnagrams(str1,str2) && !visited[j]){
                    temp.add(str2);
                    visited[j] = true;
                }

            }

            if(temp.size() > 0){
                result.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return result;
    }
}

// Better approach using sorting and hashmap

class Solution{
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> hashMap = new HashMap<>();

        for(String str: strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            hashMap.computeIfAbsent(sorted , k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(hashMap.values());
    }
}