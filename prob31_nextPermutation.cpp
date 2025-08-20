#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
    
        int arrSize = nums.size() , index =-1;

        // find the smaller element than next
        for(int i= arrSize - 2 ;i>=0;i--){
            if(nums[i] < nums[i+1]){
                index = i; 
                break;
            }
        }

        if(index == -1){
            reverse(nums.begin() , nums.end());
            return;
        }

        for(int j = arrSize-1 ;j>index;j--){
            if(nums[index] < nums[j]){
                swap(nums[index] , nums[j]);
                break;
            }
        }

        reverse(nums.begin()+index+1 , nums.end());

    }
};


int main() {
    
    vector<int> nums = {18,23,56,45,11,1,2,54,78,99};
    // vector<int> nums = {3,2,1};
    Solution s;
    s.nextPermutation(nums);

    for(const int& a :nums){
        cout<<a<<" ";
    }

    return 0;
}

/*
    stl_solution is next_permutation(a.begin(),a.end());
    solution 
      1) brute force
      
      2) algo
        
        1. find arr[i] < arr[i-1] for finding small number 
        2. 
*/