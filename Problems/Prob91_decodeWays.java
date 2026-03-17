public class Prob91_decodeWays {
    public int numDecodings(String s) {
        return helper(s, 0);
    }

    public int helper(String s , int index ){
        
        // base case
        if(index == s.length()) return 1;
        
        // if starts with 0 invalid 
        if(s.charAt(index) == '0') return 0;

        int count= 0 ;

        // 1 way 
        count += helper(s , index + 1);

        // 2 digit 
        if(index+1 < s.length() && ((s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))){
            count += helper(s , index + 2);
        }
        
        return count;
    }
    
    public int helper2(String s , int index , Integer[] memo){
        
        // base case 
        if(index == s.length()) return 1;

        if(s.charAt(index) == '0') return 0;


        if(memo[index] != null) return memo[index];

        memo[0] = 0;
        int count = 0; 

        count += helper( s, index +1);

    
        // 2 digit 
        if(index+1 < s.length() && ((s.charAt(index) == '1' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6'))){
            count += helper(s , index + 2);
        }
    

        memo[index] = count;

        return count;

    }
}
