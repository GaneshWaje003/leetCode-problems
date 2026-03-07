import java.util.Stack;

public class Prob_84_largestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(heights));
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0  , width = 0  , height  =  0 ;
        int  n = heights.length;
        int rightSmall[] = new int[n];
        int leftSmall[] = new int[n];

        
        for (int i = n-1; i >= 0; i--) {
            
            while(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                stack.pop();
            } 

            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        while(stack.size() > 0){
            stack.pop();
        }   

        for(int i  = 0 ; i < n ;i++){
            while(stack.size() > 0 && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for(int i = 0 ; i < n ; i++){
            width = rightSmall[i] - leftSmall[i] - 1;
            height = heights[i];
            maxArea = Math.max(maxArea , width * height);
        }


        return maxArea;
    }
}