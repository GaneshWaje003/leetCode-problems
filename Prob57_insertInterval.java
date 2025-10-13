import java.util.ArrayList;
import java.util.List;

public class Prob57_insertInterval {
    public static void main(String[] args) {

        Solution obj = new Solution();
        int[][] intervals = {
        { 1, 2 },
        { 3, 5 },
        { 6, 7 },
        { 8, 10 },
        { 12, 16 },
        };
        // int[][] intervals = {
        //         { 1, 3 },
        //         { 6, 9 },
        // };
        int[] newInterval = { 4,8 };

        obj.insert(intervals, newInterval);
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int size = intervals.length;

            if(size == 0 ){
            result.add(newInterval);
            return result.toArray(new int[result.size()][]);
        }

        int[] current = intervals[0];

        for(int[] row:intervals){

            System.out.println("current interval : " + row[0] + " " + row[1]);

            // no over and push current 
            if(row[1] < newInterval[0]){
                result.add(row);
                continue;
            }

            // overlap occurs
            if(row[0] <= newInterval[1]){
                newInterval[0] = Math.min(newInterval[0], row[0]);
                newInterval[1] = Math.max(newInterval[1], row[1]);
                continue;
            }

            // no over and push new interval 
            if(row[0] > newInterval[1]){
                result.add(newInterval);
                newInterval = row;
                continue;
            }


        }     
        
        // add last new interval
        result.add(newInterval);

        for(int [] r: result){
            System.out.println(r[0] + " " + r[1]);
        }

        // last inteverval add 


        return result.toArray(new int[result.size()][]);
    }
}