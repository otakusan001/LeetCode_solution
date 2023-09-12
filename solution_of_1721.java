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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = new ListNode();
        ListNode slow = head;
        ListNode fast = head;
        int tempval;
        k--;
        while(k-- > 0){
            if(fast != null) fast = fast.next;
        }
        temp = fast;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        tempval = slow.val;
        slow.val = temp.val;
        temp.val = tempval; 
        return head;
    }
}
