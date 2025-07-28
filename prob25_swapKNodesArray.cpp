/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:
Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000
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
    ListNode *reverseKGroup(ListNode *head, int k)
    {

        ListNode *newHead = nullptr;
        ListNode *curr = head;
        ListNode *prev = new ListNode(0);
        ListNode *next = nullptr;
        ListNode *PrevGroupEnd = nullptr;
        ListNode *CurrGroupEnd = nullptr;
        ListNode *CurrGroupHead = nullptr;
        ListNode *temp = nullptr;


        if(k <= 1) return head;

        while (curr)
        {

            temp = curr;
            int count = 0;
            while (temp && count < k)
            {
                temp = temp->next;
                count++;
            }

            if (count < k)
            {
                if (PrevGroupEnd != nullptr)
                    PrevGroupEnd->next = curr;
                break;
            }

            for (int i = 0; i < k; i++)
            {

                next = curr->next;
                curr->next = prev;
                if (CurrGroupEnd == nullptr)
                    CurrGroupEnd = prev;
                prev = curr;
                curr = next;
            }

            if (newHead == nullptr)
            {
                newHead = prev;
            }

            CurrGroupHead = prev;

            if (PrevGroupEnd == nullptr)
            {
                PrevGroupEnd = head;
            }
            else
            {
                PrevGroupEnd->next = CurrGroupHead;
                PrevGroupEnd = CurrGroupEnd;
            }

            prev = nullptr;
            CurrGroupEnd = nullptr;
            CurrGroupHead = nullptr;
        }

        return newHead;
    }
};

int main()
{
    Solution solution;

    ListNode *head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);

    int k = 2;

    ListNode *result = solution.reverseKGroup(head, k);

    cout << endl
         << "list ---------" << endl;
    while (result)
    {
        cout << result->val << " ";
        result = result->next;
    }

    return 0;
}