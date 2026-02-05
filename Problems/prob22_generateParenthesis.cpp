/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

*/


#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:

    void generate(vector<string>& result , string curr , int open , int close , int n){
        if(curr.length() == n*2  ){
            result.push_back(curr);
            return ;
        }

        if( open < n){
            generate(result ,curr+"(",open+1,close,n);
        }

        if( close < open){
            generate(result ,curr+")",open,close+1,n);
        }

    }

    vector<string> generateParenthesis(int n) {
        
        vector<string> result = {};
        generate(result,"",0,0,n);

        for(string s:result){
            cout<<s<<endl;
        }
        return result;
    }
};

int main() {
    
    Solution s;
    s.generateParenthesis(3);

    return 0;
}


/*
--- algorithm
imp -> Cn=((1/n+1)*(2n/n)); ---- number of parenthesis can be generated

1) read input number string
2) 

*/

