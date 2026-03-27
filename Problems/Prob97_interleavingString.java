import java.util.ArrayList;
import java.util.List;

public class Prob97_interleavingString {
    public static void main(String[] args) {
        Prob97_interleavingString obj = new Prob97_interleavingString();
        obj.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    public void recursive(int n){
        if(n == 10) return;

        recursive(n+1);

        System.out.println(n);
    }


    Boolean[][] memo ;

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        memo = new Boolean[s1.length()+1][s2.length()+1];

        return solve(s1 , s2 , s3 , 0 ,0 , 0);

    }

    public boolean solve(String s1 , String s2 , String s3 , int i1 , int i2 , int i3){
        if(i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) return true;

        if(i3 == s3.length()) return false;

        if(memo[i1][i2] != null){
            return memo[i1][i2];
        }

        boolean result = false;

        // opt 1 take from s1 if chars match
        if(i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)){
            result = result || solve(s1, s2, s3, i1+1, i2, i3+1);
        }

        if(i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)){
            result = result || solve(s1 ,s2 , s3 , i1 , i2 + 1 , i3 + 1);
        }
        
        memo[i1][i2] = result;

        return result;
    }

}


/*
    remark 
    * more thinking on m-n adding extra logic 
    * just use normal pointers to match strings 
    * find recursive sol first then the dp ( memoization )

*/