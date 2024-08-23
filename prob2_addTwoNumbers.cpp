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
    ListNode *addIt(string sum1, string sum2)
    {

        ListNode* head = new ListNode();
        ListNode* temp = head;
        int output =0, carry =0;
        int os;
        

        for (int i = sum1.length()-1; i >=0 ; i--)
        {

            output = (((sum1[i] - '0') + (sum2[i] - '0') )+  carry);    
            carry = output % 10;
            os = (output%10)+'0';

            if(head == nullptr){
                head->val= os;
            }else{
                while(temp != nullptr){
                    temp = temp->next;
                }
                ListNode *newNode = new ListNode(os);
                temp->next = newNode;
            }
                 
        }


        return head;
    
    }

    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {

        string sum1, sum2, sum3;

        ListNode *temp1;
        ListNode *temp2;
        ListNode *output;

        temp1 = l1;
        temp2 = l2;

        while (temp1 != nullptr)
        {
            char c = temp1->val + '0';
            sum1 = c + sum1;
            temp1 = temp1->next;
        }

        while (temp2 != nullptr)
        {
            char c = temp2->val + '0';
            sum2 = c + sum2;
            temp2 = temp2->next;
        }

        output = addIt(sum1, sum2);

        return output->next;
    }
};
int main()
{
    ListNode *l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode *l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    Solution s;
    s.addTwoNumbers(l1, l2);

    return 0;
}