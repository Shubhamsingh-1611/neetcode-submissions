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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Count total nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        // Find the target position from the start (1-indexed)
        int targetPos = count - n + 1;
        
        // Edge Case: If we need to remove the head node
        if (targetPos == 1) {
            return head.next;
        }
        
        // Step 2: Traverse to the (targetPos - 1)th node
        curr = head;
        int c = 1;
        while (c < targetPos - 1) {
            curr = curr.next;
            c++;
        }
        
        // Skip the N-th node from the end
        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        } 
        
        return head;
    }
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //   ListNode curr = head;
    //   int count =0;
    //   while(curr!=null) {
    //     count++;
    //     curr = curr.next;
    //   }
    //   int node = count-n+1;

    //   curr = head;
    //   int c = 1;
    //   while(c < count-2) {
    //     curr = curr.next;
    //     c++;
    //   }
    //   if(curr !=null && curr.next !=null ){
    //     curr.next = curr.next.next;
    //   } 

    //   return head;
    // }
}
