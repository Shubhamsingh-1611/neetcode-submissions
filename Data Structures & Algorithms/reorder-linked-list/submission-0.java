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
    public void reorderList(ListNode head) {
        //find mid
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev  = null;

        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode head2 = prev;

        ListNode head1 = head;
        while(head2.next !=null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            
            head1.next = head2;
            head2.next = temp1;

            head1 = temp1;
            head2 = temp2;
        }
   
    }
}
