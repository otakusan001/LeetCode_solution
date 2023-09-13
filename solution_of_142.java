/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = new ListNode();
        ListNode slowNode = new ListNode();
        fastNode = head;slowNode = head;
        while(fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if(fastNode == slowNode){
                slowNode = head;
                while(slowNode != fastNode){
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}
