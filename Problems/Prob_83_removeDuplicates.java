public class Prob_83_removeDuplicates {
    public static void main(String[] args) {
        
    }
}

//  Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0 , head);

        ListNode temp = new ListNode();

        temp = dummy;

        ListNode prev = new ListNode(0 , dummy);


        while(temp.next != null){
            
            // handling duplicate logic
            if(temp.val == temp.next.val){
                
                prev  = temp ;

                while(temp.val == temp.next.val){
                    temp = temp.next;
                }

                prev.next = temp;

            }



            temp = temp.next;
        }


        return dummy.next;
        
    }
}