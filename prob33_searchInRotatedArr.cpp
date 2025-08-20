#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {

        int left = 0, right = nums.size() - 1;
        int mid  = 0;

        while(left <= right){
            mid = left + (right - left) /2;

            if(nums[mid] == target) return mid;


            // check if the left half
            if(nums[left] <= nums[mid]){
                if(nums[mid] >= target && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){                    
                    left = mid + 1;
                }else{
                    right = mid - 1;   
                }
            }
        }

        return -1;
    }
};


int main() {
    Solution s;
    vector<int> nums = {4,5,6,7,0,1,2};
    int target = 0;
    int result = s.search(nums, target);
    cout << "Target found at index: " << result << endl;
    return 0;
}