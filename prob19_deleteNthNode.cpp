/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
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
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        ListNode* temp = head ;
        ListNode* newNext(0);
        ListNode* prev(0);

        int linkSize = 0 ,nodeToDeleteValue = 0;

        
        
        // find number index
        while(temp != NULL){
            // cout<<size<<endl;
            linkSize++;
            temp = temp->next;
        }

        if(n == linkSize){
            ListNode* nodeToDelete = head;
            head = head->next;
            delete nodeToDelete;
            return head; 
        }
        
        // finding the node
        temp = head;
        for(int i=1;i<linkSize-n;i++){
            temp = temp->next;
        } 

        //deleting node
        ListNode* nodeToDelete = temp->next;
        temp->next = temp->next->next;
        delete nodeToDelete;

        return head;

    }
};

int main()
{
    ListNode* node4 = new ListNode(14);
    ListNode* node3 = new ListNode(13, node4);
    ListNode* node2 = new ListNode(12, node3);
    ListNode* node1 = new ListNode(11, node2);
    ListNode* head = new ListNode(10, node1);
    
    ListNode* proccesedHead = new ListNode(0);

    Solution s; 
    proccesedHead = s.removeNthFromEnd(head,1);

    while(proccesedHead != NULL){
        cout<<proccesedHead->val<<" ";
        proccesedHead=proccesedHead->next;
    }

    return 0;
}
