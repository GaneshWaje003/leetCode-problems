import java.util.List;

public class Prob61_roatateLinkList{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
   

        int k = 1;

        Solution s = new Solution();
        ListNode result = s.rotateRight(head, k);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;
        // find last of the node
        ListNode oldTail = head;
        int n = 1;
        if(oldTail.next == null) return head;
        while(oldTail.next != null) {
            oldTail = oldTail.next;
            n++;
        }

        k = k % n ;
        if(k == 0) return head;
        
        oldTail.next = head;

        int newTail = n - k -1;
        ListNode newTailNode = head;
        for(int i = 0; i < newTail; i++) {
            newTailNode = newTailNode.next;
        }

        // find new head
        ListNode newHead = newTailNode.next;
        newTailNode.next = null;

        return newHead;
    }
}