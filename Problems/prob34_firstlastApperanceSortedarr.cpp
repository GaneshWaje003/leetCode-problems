#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    int firstNum(vector<int> &nums, int target){
        int right = nums.size() - 1, left = 0, mid = 0;
        int first  = -1 ;

        while (left <= right)
        {

            mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                first = mid;
                right = mid - 1;
            }
            else if (nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return first;
    }
    
    int secNum(vector<int> &nums, int target){
        int right = nums.size() - 1, left = 0, mid = 0;
        int first  = -1 ;

        while (left <= right)
        {

            mid = left + (right - left) / 2;

            if (nums[mid] == target)
            {
                first = mid;
                left = mid + 1;
            }
            else if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return first;
    }

    vector<int> searchRange(vector<int> &nums, int target)
    {
        return {firstNum(nums,target) , secNum(nums,target)};
    }
};

int main()
{
    Solution s;
    vector<int> nums = {5, 7, 7, 8, 8, 10};
    int target = 8;
    vector<int> result = s.searchRange(nums, target);
    cout << "Target found at indices: [" << result[0] << ", " << result[1] << "]" << endl;
    return 0;
}