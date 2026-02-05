#include <iostream>
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class Solution
{
public:
   vector<int> findSubstring(string s, vector<string>& words) {
    vector<int> result;
    if (words.empty() || s.empty()) return result;
    int wordLen = words[0].size();
    int numWords = words.size();
    int totalLen = wordLen * numWords;
    if (s.size() < totalLen) return result;
    unordered_map<string, int> wordCount;
    for (auto& w : words) wordCount[w]++;

    // Loop over possible offsets
    for (int offset = 0; offset < wordLen; ++offset) {
        int left = offset, count = 0;
        unordered_map<string, int> window;

        for (int right = offset; right + wordLen <= s.size(); right += wordLen) {
            string word = s.substr(right, wordLen);

            if (wordCount.count(word)) {
                window[word]++;
                count++;
                
                while (window[word] > wordCount[word]) {
                    string leftWord = s.substr(left, wordLen);
                    window[leftWord]--;
                    count--;
                    left += wordLen;
                }

                if (count == numWords) {
                    result.push_back(left);
                }

            } else {
                window.clear();
                count = 0;
                left = right + wordLen;
            }
        }
    }
    return result;
}

};

int main()
{
    string s = "barfoothefoobarman";
    vector<string> words = {"foo", "bar" ,"the"};
    Solution sol;
    vector<int> res = sol.findSubstring(s, words);
    for (int x : res)
        cout << x << " "; // Expected output: 0 9
    return 0;
}
