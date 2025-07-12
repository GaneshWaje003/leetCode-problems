/*   23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

Constraints:
    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.

*/

#include <iostream>
#include <vector>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *mergeKLists(vector<ListNode *> &lists){
        ListNode* result = nullptr ;
        
        // ListNode* newNode(0);

        // visiting each list start pointer 
        for(auto &list:lists){
            ListNode* temp = list;
            
            // iteratring in the current list 
            while(temp){

                //creating new node for inserting
                ListNode* newNode = new ListNode(temp->val);
                
                // if result is empty 
                if(!result){
                    result = newNode;
                }else{
                    

                    ListNode *curr = result;
                    ListNode *prev = nullptr;

                   while (curr && curr->val < newNode->val)
                    {
                        prev = curr;
                        curr = curr->next;
                    }

                    if (!prev)
                    {
                        // Insert at head
                        newNode->next = result;
                        result = newNode;
                    }
                    else
                    {
                        // Insert between prev and curr
                        prev->next = newNode;
                        newNode->next = curr;
                    }
                    
                    
                }

                temp = temp->next;
            }
        }

        return result;
    }
};

int main()
{

    // [[1,4,5],[1,3,4],[2,6]]

    ListNode *third_last = new ListNode(6);
    ListNode *third_first = new ListNode(2, third_last);

    ListNode *second_third = new ListNode(4);
    ListNode *second_second = new ListNode(3, second_third);
    ListNode *second_first = new ListNode(1, second_second);

    ListNode *first_third = new ListNode(5);
    ListNode *first_second = new ListNode(4, first_third);
    ListNode *first_first = new ListNode(1, first_second);

    vector<ListNode *> lists = {first_first, second_first, third_first};

    Solution s;
    ListNode *result = s.mergeKLists(lists);

    while (result != nullptr)
    {
        cout << result->val << " ";
        result = result->next;
    }
    cout << endl;

    return 0;
}