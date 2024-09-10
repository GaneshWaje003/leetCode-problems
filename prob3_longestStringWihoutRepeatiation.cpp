/*

3. Longest Substring Without Repeating Characters ( Medium )



Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

*/



// <------------------------------------------------------- code ------------------------------------------------------->



#include<iostream>
using namespace std;

    class Solution {

    public:
        int lengthOfLongestSubstring(string s) // abcdaabdssfsa
        {
            string fstring = "";
            string prevString ="";
            

            for(char c:s){
                
                size_t pos = fstring.find(c);

                if( pos != std::string::npos){
                    fstring = fstring.substr(pos+1);
                }
                
                fstring +=c;

                if(prevString.length() < fstring.length()) prevString = fstring ;
                
            }

            return prevString.length();
        }
    };


int main(){

    Solution s;
    cout<<s.lengthOfLongestSubstring("abcabcbb");

    return 0;
}