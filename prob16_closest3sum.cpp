/*

---------------------- 16. 3Sum Closest ----------------------


Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:
    3 <= nums.length <= 500
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104

*/

#include<iostream>
#include<vector>
#include<algorithm>
#include <cstdlib>
using namespace std;

class Solution {
    public:
        int threeSumClosest(vector<int>& nums, int target) {
            int result = nums[0]+nums[1]+nums[2],temp , size = nums.size();

            sort(nums.begin(),nums.end());
            
            for(int i=0;i<size;i++){

                if(i > 0 && nums[i] == nums[i -1]) continue;

                int left = i+1 , right = size - 1;

                while(left < right){
                    
                    temp = nums[i] + nums[left] + nums[right];

                    if(temp == target){
                        return temp;
                    }

                    if(abs(temp - target) < abs(result-target)){
                        result = temp;
                    }

                    if(temp < target){
                        left++;
                    }else{
                        right--;
                    }
                    

                }

            }

            return result;
            
        }
    };

int main() {

    Solution s; 
    vector<int> nums = {1,1,1,1};
    cout<<s.threeSumClosest(nums,100);


    return 0;
}