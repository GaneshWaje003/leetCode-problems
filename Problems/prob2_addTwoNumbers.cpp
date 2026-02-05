/*
1) ADD TWO NUMBERS

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.


*/

// <------------------------------------------------------- code ------------------------------------------------------->
 


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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {

        int sum1 = 0,  carry =0;
        ListNode* head = new ListNode(0);
        ListNode* temp = head;

        
        while(l1 != nullptr || l2 != nullptr || carry != 0){
        

            if(l1 !=nullptr){
                sum1 +=l1->val;
                l1=l1->next;
            }else{
                sum1+=0;
            }
            

            if(l2 != nullptr){
                sum1 +=l2->val;
                l2=l2->next;
            }else{
                sum1+=0;
            }

            sum1 += carry;
            carry = sum1/10;
            sum1 = sum1%10;

            ListNode* newNode = new ListNode(sum1);         // 9999999
                                                            // 9999
            temp->next = newNode; 
            temp = newNode;
            cout<<sum1;

            sum1 =0;

        }

        return head->next;
     
    }
};

int main()
{
    ListNode *l1 = new ListNode(9, new ListNode(9, new ListNode(9 ,new ListNode(9 ,new ListNode(9 , new ListNode(9 , new ListNode(9 )) ) ))));
    ListNode *l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));

    Solution s;

    s.addTwoNumbers(l1, l2);

    return 0;
}