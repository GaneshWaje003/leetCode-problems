import java.util.Stack;

public class Prob_85_largest_rectangle {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;
        int[] heights = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, width = 0, height = 0;
        int n = heights.length;
        int rightSmall[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            rightSmall[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        int leftSmall[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            leftSmall[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (rightSmall[i] - leftSmall[i] - 1) * heights[i]);
        }

        return maxArea;

    }
}