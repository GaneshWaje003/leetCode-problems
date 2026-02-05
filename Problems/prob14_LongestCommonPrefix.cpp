/*


Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 
------------------- Constraints:---------------

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters if it is non-empty.

*/


#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        
        if(strs.size() >= 200){
            cout<<"Array size exceeded";
            return "";
        }

        // defining the variables
        string firstString = "" , pattern = "";
        char charToMatch;
        bool allMatch = true;

        // initializing the variables 
        firstString = strs[0];

        for(int i=0;i<firstString.length();i++){
            charToMatch = firstString[i];

            for(const auto& pair:strs){
                if(pair[i] != firstString[i]){
                    allMatch = false;
                    break;
                }
            }

            if(allMatch){
                pattern += firstString[i];
            }

        }

        return pattern;
        
    }
};


int main() {
    vector<string> words ={"flower" , "floent" , "flow"};
    Solution obj;
    cout<<obj.longestCommonPrefix(words); 
    

    return 0;
}