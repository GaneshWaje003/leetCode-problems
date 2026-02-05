import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob56_joinIntervals {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };

       s.merge(intervals);
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        int size = intervals.length;
        List<int[]> result = new ArrayList<>();

        // ? first sort the arr elements based on first index
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];

        // ? iterate
        for(int i=1;i<=size-1;i++){
            if(intervals[i][0] <= current[1] ){
                current[1] =  Math.max(current[1], intervals[i][1]);
            }else{
                result.add(current);
                current = intervals[i];
            }            
        }

        // ?  add the interval
        result.add(current);
       

        return result.toArray(new int[result.size()][]);
    }
}