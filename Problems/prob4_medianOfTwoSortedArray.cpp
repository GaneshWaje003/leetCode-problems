/*
4. Median of Two Sorted Arrays
Hard
Topics
Companies

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.



Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106


*/

// <------------------------------------------------------- code ------------------------------------------------------->

#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
    {

        int i = 0, j = 0;
        vector<int> farray;

        while (i < nums1.size() && j < nums2.size())
        {

            if (nums1[i] < nums2[j])
            {
                farray.push_back(nums1[i]);
                i++;
            }
            else
            {
                farray.push_back(nums2[j]);
                j++;
            }

        }

        while(i < nums1.size()){
            farray.push_back(nums1[i]);
            i++;
        }

        while(j < nums2.size()){
            farray.push_back(nums2[j]);
            j++;
        }


        
        if(farray.size()%2 == 1){
            int mid = farray.size()/2;
            return farray[mid];
        }else{
            int mid = farray.size()/2;
            double result = (farray[mid] + farray[mid-1])/2.0;
            return result;
        }



        return 0;
    }

};

int main()
{
    vector<int> vec1;
    vec1.push_back(1);
    vec1.push_back(2);
 

    vector<int> vec2;
    vec2.push_back(3);
    vec2.push_back(4);


    Solution s;
    cout<<s.findMedianSortedArrays(vec1, vec2);
    return 0;
}