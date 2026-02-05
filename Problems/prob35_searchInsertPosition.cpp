#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0 , right = nums.size()-1 , mid =0;

        while(left <=right){
            mid = left + (right -left) / 2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return left;
    }
};

int main() {
    
    Solution sol;
    vector<int> nums = {1, 3, 5, 6};
    int target = 7;
    int result = sol.searchInsert(nums, target);
    cout << "position: " << result << endl; // Output: 2

    return 0;
}