/*
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]
Explanation:

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Example 4:
Input: head = [1,2,3]
Output: [2,1,3]

Constraints:
    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
*/

#include <iostream>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution{
public:
    ListNode *swapPairs(ListNode *head){
        
        if(!head || !head->next) return head;
        
        ListNode* temp = head;
        ListNode* newHead = head->next;
        ListNode* prev = nullptr;
        ListNode* next = nullptr;
        ListNode* lastTail = nullptr;

        while(temp && temp->next){
            
            // storing prev and next
            prev = temp ;
            next = temp->next->next;

            // moving pointer of temp to second node for changing
            temp = temp->next; 

            // swaap
            prev->next = next;   
            temp->next = prev;

            // update prev // connect prev tail
            if(lastTail) lastTail->next = temp;
            lastTail = prev;


            // move temp to next pair 
            temp = next;

        }

        return newHead;
    }
};

int main()
{
    ListNode* five = new ListNode(5);
    ListNode* four = new ListNode(4,five);
    ListNode* third = new ListNode(3,four);
    ListNode* second = new ListNode(2,third);
    ListNode* first = new ListNode(1,second);

    Solution s;
    ListNode* head = s.swapPairs(first);

    while(head){
        cout<<head->val<<" ";
        head = head->next;
    }


    return 0;
}


/*

suggestion for me:
 1. examine execution manually to see error in case of pointers as we can't print logs here 
*/