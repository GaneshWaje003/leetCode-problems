// package Problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob92_reverseLinkList2 {

    public static void main(String[] args) {

        Prob92_reverseLinkList2 obj = new Prob92_reverseLinkList2();

    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        // Get the left side 
        ListNode temp = dummy;
        for(int i = 0 ; i < left -1  ; i++){
            temp = temp.next;
        }

        // left position is after next
        ListNode leftPrev = temp;
        ListNode curr = temp.next;          


        // reversed from left to right 
        for(int i = 0 ; i < right - left ;i++){
            ListNode nextNode = curr.next; // store next link 

            curr.next = nextNode.next;
            nextNode.next = leftPrev.next;  // insert nextNode at front;
 
            leftPrev.next = nextNode;  // update new next node 
        }

        return dummy.next;


    }
}