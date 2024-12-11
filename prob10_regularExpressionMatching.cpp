/*
10. Regular Expression Matching

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).


Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".


Constraints:

    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.


*/

#include <iostream>
#include <string>
using namespace std;

class Solution
{

public:
    bool isMatch(string s, string p)
    {

        int iter;
        string patterWitoutSymbol = "";

        if (p.find('*') == string::npos || p.find('.') == string::npos)
        {
            return p == s;
        }
        else if (p == ".*")
        {
            return true;
        }
        else if (p == "")
        {
            return false;
        }

        iter = 0;

        while (iter < p.length())
        {
            if (p[iter] == '*')
            {

                char multiChar = p[iter - 1];
                while (patterWitoutSymbol.length() < s.length())
                {
                    patterWitoutSymbol += multiChar;
                    cout<<"* encountered New String : "<<patterWitoutSymbol<<endl;
                }
            }
            else if (p[iter] == '.')
            {
                patterWitoutSymbol += s[iter];
            cout<<". encountered : "<<patterWitoutSymbol<<endl;
            }
            else
            {
            cout<<patterWitoutSymbol;
                patterWitoutSymbol += p[iter];
            }
            iter++;
            cout<<"Nothing encountered : "<<patterWitoutSymbol<<endl;
        }

        if (patterWitoutSymbol == s)
        {
            cout<<"last string : "<<patterWitoutSymbol<<endl;
            return true;
        }
    }
};

int main()
{

    Solution s;
    cout << s.isMatch("aaa", "a*")<<endl;

    return 0;
}