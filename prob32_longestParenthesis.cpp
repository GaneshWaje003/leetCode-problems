#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int longestValidParentheses(string s){
        
        int result =0 ;
        vector<int> stack = {-1};

        
        for(int i=0;i<s.length();i++){
            if(s[i] == '('){
                stack.push_back(i);
            }else{
                stack.pop_back();
                if(stack.empty()){
                    stack.push_back(i);
                }else{
                    result = max(result, i - stack.back());
                    cout<<result<<endl;
                }
            }

        }

        return result;
    }
};

int main()
{
    Solution s;
    cout << s.longestValidParentheses("))()(()");
    return 0;
}