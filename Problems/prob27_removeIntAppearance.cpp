#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        

        if(nums.empty()) return 0;

        int k = 0;

        for(int i=0;i<nums.size();i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                cout<<nums[k]<<endl;
                k++;
            }
        }
        return k;
    }
};

int main() {
    
    Solution s;
    vector<int> nums = {3,2,2,3};
    cout<<s.removeElement(nums,2);

    return 0;
}