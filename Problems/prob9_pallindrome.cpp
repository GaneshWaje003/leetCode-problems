/*

9. Palindrome Number

Given an integer x, return true if x is a
palindrome and false otherwise.

 

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 

Constraints:
    -231 <= x <= 231 - 1
*/

#include<iostream>
#include<climits>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        
        int number = 0;
        int ogNumber = x;
        // cout<<x;

        if(x < 0 || x > INT_MAX){
            return false;
        }

        while(ogNumber != 0){
            int digit = ogNumber % 10;

            if(number > (INT_MAX - digit) / 10 ){
                return 0;
            }

            ogNumber /= 10;
            number = number * 10 + digit;
        }

        if(number == x){
            return true;
        }
    
        return false;

    }
};

int main() {
    Solution s;
    cout<<s.isPalindrome(1234567899);  
    return 0;
}