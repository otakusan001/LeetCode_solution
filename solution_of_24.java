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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        if(curr == null) return head;
        while(curr.next != null && curr.next.next != null){
            temp1 = curr.next;
            temp2 = curr.next.next.next;
            curr.next = curr.next.next;
            curr.next.next = temp1;
            curr.next.next.next = temp2;
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
