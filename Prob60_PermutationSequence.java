public class Prob60_PermutationSequence {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 3, k = 3;
        System.out.println(obj.getPermutation(n, k));
    }
}

class Solution {
    
    void helper(StringBuilder sb , int n , String temp , boolean[] visited){
        if(temp.length() == n){
            // System.out.println(temp);
            sb.append(temp);
            return;
        }

        for(int i = 0 ; i<n ;i++){ 
            if(!visited[i]){
                visited[i]=true;
                helper(sb,n,temp+(i+1),visited);
                visited[i]=false;
            }
        }

    }

    public String getPermutation(int n, int k) {
        String result = "";

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];

        helper(sb, n, result, visited);
        result = sb.substring(n*k-n , n*k);

        return result;
    }
}