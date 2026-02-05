/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.
*/

#include <iostream>
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
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {

        if (!list1)
        {
            ListNode *head = nullptr;
            ListNode **tail = &head;
            while (list2)
            {
                *tail = new ListNode(list2->val);
                tail = &((*tail)->next);
                list2 = list2->next;
            }
            return head;
        }

        ListNode *temp1;
        ListNode *temp2;
        ListNode *temp3;
        ListNode *newNode;
        int currValue = 0;

        temp1 = list1;
        temp2 = list2;

        while (temp2 != NULL)
        {

            // taking 2nd list value
            newNode = new ListNode(temp2->val);

            // iterating through the list 1 to find valus actual spot
            if (newNode->val < list1->val)
            {
                newNode->next = list1;
                list1 = newNode;
            }
            else
            {
                temp1 = list1;

                while (temp1->next && temp1->next->val < newNode->val)
                {
                    temp1 = temp1->next;
                }

                // inserting new node
                temp3 = temp1->next;
                temp1->next = newNode;
                newNode->next = temp3;
            }

            // go to next node of temp2
            temp2 = temp2->next;
        }
        return list1;
    }
};
int main()
{

    Solution s;

    // First list: 1 -> 2 -> 4
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(2);
    l1->next->next = new ListNode(4);

    // Second list: 1 -> 3 -> 4
    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);

    ListNode *merged = s.mergeTwoLists(l1, l2);

    // Print merged list
    while (merged)
    {
        cout << merged->val << " ";
        merged = merged->next;
    }

    // s.mergeTwoLists
    return 0;
}

/*
 algorith
 1. iterate through the second list
 2. find its position acording to values as 2 are sorted list
 3. insert node there
 4. continue for next nodes

*/