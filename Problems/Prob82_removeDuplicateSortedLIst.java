import java.util.ArrayList;
import java.util.List;

public class Prob82_removeDuplicateSortedLIst {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(5);
        ListNode node4_2 = new ListNode(4, node5);
        ListNode node4_1 = new ListNode(4, node4_2);
        ListNode node3_2 = new ListNode(3, node4_1);
        ListNode node3_1 = new ListNode(3, node3_2);
        ListNode node2 = new ListNode(2, node3_1);
        ListNode head = new ListNode(1, node2); // head -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5

        Solution s = new Solution();
        s.deleteDuplicates(head);


        ListNode temp = head;

        while(temp != null){
            System.out.println(temp.val);
            temp=temp.next;
        }

    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        List<Integer> numList = new ArrayList<>();

        ListNode temp = head;
        ListNode prev = new ListNode();

        while (temp != null) {

            if (numList.contains(temp.val)) {
                ListNode temp2 = temp;
                prev.next = temp2.next;
                temp.next = null;
            } else {
                numList.add(temp.val);
            }

            prev = temp;
            temp = temp.next;
        }

        return temp;

    }
}