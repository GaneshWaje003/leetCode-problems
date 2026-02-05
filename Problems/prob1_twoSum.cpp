/*

? 1. Two Sum


Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. 
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4,8,12,9,0,1,121,10,40], target = 23;
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


*/


// code --------------------
#include <vector>
#include <iostream>
using namespace std;


vector<int> addData(vector<int>& nums , int target){

vector<int> outputRange;
int data=0 ;
bool isTrue = false;

    for(int i =0;i<nums.size();i++){
        if(isTrue) break;
        for(int j=i+1;j<nums.size();j++){
            if(nums[i]+nums[j] == target){
                outputRange.push_back(i);
                outputRange.push_back(j);
                
                cout<<"i : "<<i<<" j : "<<j<<endl;
                isTrue = true;
                break;
            }
        }
    }

};

int main() {
    vector<int> vec;
    vec.push_back(1);
    vec.push_back(6);
    vec.push_back(3);
    vec.push_back(9);
    vec.push_back(4);

    addData(vec,12);
 
    return 0;
}
