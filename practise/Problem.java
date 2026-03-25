import java.util.ArrayList;
import java.util.List;

public class Problem {
    public static void main(String[] args) {

        Problem obj = new Problem();

        // System.out.println(obj.findSingle( new int[]{4 , 1 , 2 , 1 , 2}));

        System.out.println(obj.lcm(90 , 10));
    }

    
    public int findSingle(int[] nums){
        int result = 0 ; 

        for(int i : nums){
            result ^= i;
        }

        return result;
    }

    public int gcd(int a , int b){
        while(b != 0){
            int rem = a % b ; 
            a = b ; 
            b = rem;
        }
        return a;
    }

    public int lcm(int a , int b ){
        return ( a * b) / gcd(a , b);
    }


}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// class Solution {
//     public ListNode reverseBetween(ListNode head, int left, int right) {    

//     }
// }


class NumMatrix {

    private int[][] prefixSum ;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length+1][matrix[0].length+1];

        for(int i = 1 ; i <= matrix.length;i++){
            for(int j = 1 ; j <= matrix[0].length;j++){
                prefixSum[i][j] = 
                    prefixSum[i-1][j] +
                    prefixSum[i][j-1] -
                    prefixSum[i-1][j-1] +
                    matrix[i-1][j-1]; 
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return 
            prefixSum[row2+1][col2+1] -
            prefixSum[row1][col2+1] - 
            prefixSum[row2+1][col1] + 
            prefixSum[row1][col1]; 
    }


    // to find duplicate entries 

    public int[] duplicates(int[] nums){

        List<Integer> list = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();

        for(int i : nums){
            if(list.contains(i)) duplicates.add(i);
            else list.add(i);
        }

        return duplicates.stream().mapToInt(Integer::intValue).toArray();
    
    }



}