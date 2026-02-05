#include<iostream>
using namespace std;

class Solution {
public:
    int strStr(string haystack, string needle) {

            for(int i=0;i<haystack.length();i++){
                if(haystack[i] == needle[0]){
                    string window = haystack.substr(i,needle.length());

                    if(window == needle){
                        return i;
                    }
                }
            }

        return -1;
    }
};


int main() {
  
    // Solution s;
    // cout<<s.strStr("sadbutsad" , "sad");

    int b = -2147483648;
    int c = -1;

    long long a =  static_cast<long long>(b)/c;
    cout<<a;


    return 0;
}