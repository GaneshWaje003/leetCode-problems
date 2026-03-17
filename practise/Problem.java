public class Problem {
    public static void main(String[] args) {

        Problem obj = new Problem();
       System.out.println(obj.numDecodings("123"));

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = helper(l1, l2, 0);

        return temp;
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {

        // base case 
        if(l1 == null && l2 == null && carry == 0){
            return null; 
        }

        // safe value extractin 
        int val1 = (l1 != null ? l1.val : 0);
        int val2 = (l2 != null ? l2.val : 0);
    
        // operations 
        int sum = l1.val + l2.val + carry;
        int newCarry = sum / 10;
        
        ListNode node = new ListNode(sum % 10);

        node.next = (
            helper(
                (l1 != null ?  l1.next : null) , 
                (l2 != null ?  l2.next : null) ,
                newCarry 
            )
        );

        return node;
    }
}