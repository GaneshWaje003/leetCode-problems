import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(arr));
        
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer , Integer> countMap = new HashMap<>();

        for(int num: nums){
            countMap.put(num , countMap.getOrDefault(num, 0)+1);
        }

        System.out.println(countMap);


        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        
        return -1;

    }
}