import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {

        Solution s = new Solution();
        int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(s.majorityElement(arr));

    }
}

class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            if (countMap.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;

    }

    public int majorityElement2(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}