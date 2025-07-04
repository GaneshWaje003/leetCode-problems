
 /*

17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

*/


#include<iostream>
#include<vector>
#include<typeinfo>
using namespace std;

class Solution{
    

    vector<string> phonMap={
        "", "","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"
    };

public:
    
    vector<string> letterCombinations(string digits){
        

        cout<<"Started functon : "<<endl;

        // for storing the result 
        vector<string> result ={""}; 
        

        // returning function if digits are empty 
        if(digits.empty()){
            return {};
        }

        int i=0;

        while(i < digits.size()){
            vector<string> temp;
            string letters = phonMap[digits[i]-'0']; 
            for(const string& comb:result){
                for(char ch:letters){
                    temp.push_back(comb+ch);
                }

            }
            result = temp;
            cout<<i<<endl;
            i++;

        }
        

        return result;
    }
};

int main() {
    Solution s;
    vector<string> result;

    result = s.letterCombinations("2345");

    for(const string& comb : result){
        cout<<comb<<" ";
    }
    
    return 0;
}