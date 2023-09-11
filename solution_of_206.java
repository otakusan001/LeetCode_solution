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
    //recursive solution
    public ListNode reverseTwoNode(ListNode pre, ListNode head){
        if(head == null) return pre;
        ListNode temp = new ListNode();
        temp = head.next;
        head.next = pre;
        return reverseTwoNode(head, temp);
    }
    public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    //ListNode temp = new ListNode();
    //ListNode curr = head;
    /*while(curr != null){
        temp = curr.next;
        curr.next = pre;
        pre = curr;
        curr = temp;
    }
    return pre;*/
    pre = reverseTwoNode(pre, head);
    return pre;
    }
}
