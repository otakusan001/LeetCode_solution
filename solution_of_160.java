/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode startA = new ListNode();
        ListNode startB = new ListNode();
        int lengthA = 0; int lengthB = 0;
        startA = headA;
        startB = headB;

        while(startA != null){
            startA = startA.next;
            lengthA++;
        }
        while(startB != null){
            startB = startB.next;
            lengthB++;
        }
        if(lengthA > lengthB){
            int delta = lengthA - lengthB;
            startA = headA;
            startB = headB;
            while(delta-- > 0){
                startA = startA.next;
            }
            while(startA != null){
                if(startA == startB) return startA;
                startA = startA.next;
                startB = startB.next;
            }
            return null;
        }
        else{
            int delta = lengthB - lengthA;
            startA = headA;
            startB = headB;
            while(delta-- > 0){
                startB = startB.next;
            }
            while(startA != null){
                if(startA == startB) return startA;
                startA = startA.next;
                startB = startB.next;
            }
            return null;
        }
    }
}
