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
        dummy.next=head;
        ListNode leftPrev =dummy;
        for(int i =1; i<left; i++){
            leftPrev = leftPrev.next;
        }
        ListNode curr=leftPrev.next;
        ListNode prev =null;
        for(int i =0; i<=right-left; i++){
            ListNode front = curr.next;
            curr.next = prev;
            prev=curr;
             curr=front;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;

    }
}