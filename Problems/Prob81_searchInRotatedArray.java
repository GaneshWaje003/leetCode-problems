public class Prob81_searchInRotatedArray {
    public static void main(String[] args) {
        
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        
        for(int i :nums){
            if( i == target) return true;  
        }

        return false;
    }
}