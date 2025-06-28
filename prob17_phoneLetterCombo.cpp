
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
    

    vector<string> digitToLetters={
        "", "","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"
    };

public:
    
    vector<string> letterCombinations(string digits){
        

        cout<<"Started functon : "<<endl;

        // for storing the result 
        vector<string> result; 
        
        //for getting the Strings from the number using ascii values 
        vector<string> numbersLetters;

        // returning function if digits are empty 
        if(digits.empty()){
            return result;
        }


        // getting strings related the number   
        for(int i=0;i<digits.length();i++)
        {
            numbersLetters.push_back(digitToLetters[digits[i]-'0']);
        }


        // iterating for founding maximum possibilities 
        for(int i=0;i<numbersLetters.size();i++)
        {

            for(int j=0;j<numbersLetters[i];j++)
            {
                for(int k=0;k<numbersLetters[j].size();k++){
                    cout<<numbersLetters[i][k]<<numbersLetters[j+1][k]<<endl;
                }
            }
        }

        return result;
    }
};

int main() {
    Solution s;
    s.letterCombinations("23");
    
    return 0;
}