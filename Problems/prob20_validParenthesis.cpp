/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true


Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


*/


#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    bool isValid(string s) {

    vector<char> stack = {};
    
    for(char parenthesis :s){

        if(parenthesis == '(' || parenthesis == '[' || parenthesis == '{'){
            stack.push_back(parenthesis);
            // cout<<"pushed - "<<parenthesis<<endl;
        }else{

            if(stack.empty()) return false;
            
            if(stack.back() == '(' && parenthesis == ')'){
                stack.pop_back();
                // cout<<"pop - "<<parenthesis<<endl;
            }else if(stack.back() == '[' && parenthesis == ']'){
                stack.pop_back();
                // cout<<"pop - "<<parenthesis<<endl;
            }else if(stack.back() == '{' && parenthesis == '}'){
                stack.pop_back();
                // cout<<"pop - "<<parenthesis<<endl;
            }else{
                return false;
            }
        } 
        
        // if(parenthesis == ')' || parenthesis == ']' ||parenthesis == '}'){
        //     if(stack.back() == ')' || stack.back() == ']' || stack.back() == '}'){
        //         stack.pop_back();
        //         cout<<"pop :"<<parenthesis<<" ";
        //     }
        // }
    }
        return stack.empty();


    }
};

int main() {
    
    Solution s;
    cout<<s.isValid("([])");
    return 0;
}