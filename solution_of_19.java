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
//双指针解法
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode fast = new ListNode();
        ListNode slow = new ListNode();
        dummy.next = head;
        fast = dummy;
        slow = dummy;
        n++;
        while(n-- > 0){
            if(fast != null)
                fast = fast.next;
            else 
                return head;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

//普通解法
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        ListNode curr = new ListNode();
        dummy = head;
        int length = 0;
        while(dummy != null){
            dummy = dummy.next;
            length++;
        }
        if(length < n) return head;
        curr.next = head;
        int count = length - n;
        dummy = curr;
        while(count-- > 0){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
