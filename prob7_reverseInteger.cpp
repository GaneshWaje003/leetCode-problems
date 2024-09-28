/*

7. Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. 
If reversing x causes the value to go outside the signed 32-bit integer 
range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 

Constraints:

    -231 <= x <= 231 - 1

*/

#include<iostream>
#include<climits>
using namespace std;

class Solution {
public:
    int reverse(int x) {


        int num= x, rem = 0 , quo = 0,reverseNum =0;
        while(num !=0){
            

            rem = num % 10;
            num = num / 10;
            
            if( reverseNum > INT_MAX / 10 || (reverseNum == INT_MAX/10 && rem > 7)){
                return 0;
            }

            if( reverseNum < INT_MIN / 10 || (reverseNum == INT_MIN/10 && rem < -8)){
                return 0;
            }

            reverseNum = reverseNum*10 +rem; 
        }
        return reverseNum;
    }
};

int main() {
    
    Solution s;
    // cout<<INT_MAX<<endl;
    cout<<s.reverse(-1463847412);

    return 0;
}