package dailyChallenges;

public class Prob2011_finalVariableValue{
    public static void main(String[] args) {
 
        String[] operations = {"--X","X++","X++"};
        Solution s = new Solution();
        System.out.println(s.finalValueAfterOperations(operations));
    }
}

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for(String op :operations){
            if(op.equals("X++") || op.equals("++X")){
                result += 1;
            }else{
                result -= 1;
            }
        }

        return result;
    }
}