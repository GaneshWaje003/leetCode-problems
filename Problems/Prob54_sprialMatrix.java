import java.util.ArrayList;
import java.util.List;

public class Prob54_sprialMatrix {
    public static void main(String[] args) {

        // int[][] matrix = {{1,2,3 ,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1,2,3},{4 ,5,6},{7,8,9}};
        // [1,2,3,6,9,8,7,4,5]
        // [1,2,3,4,8,12,11,10,9,5,6,7]
        Solution s = new Solution();
        System.out.println(s.spiralOrder(matrix));

    }
}


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    
        List<Integer> result = new ArrayList<>();
        int m = matrix.length-1 , n = matrix[0].length-1;
        if (matrix.length == 0) return result;
        int top = 0 , bottom = m , left = 0 , right = n , i=0;
    
        while (top <= bottom && left <= right) {
            
            // col ---- (left->right) 
            for( i= left;i<=right;i++) result.add(matrix[top][i]);
            top++;
            
            // row ----(top->bottom)
            for( i = top;i<=bottom;i++) result.add(matrix[i][right]);
            right--;

            // bottom -> left 
            if(top <= bottom){
                for(i = right;i >= left;i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            // bottom -> top 
            if(left <= right){    
                for(i = bottom;i >= top;i--) result.add(matrix[i][left]);
                left++;
            }
            
        }

        return result;
        

    }
}