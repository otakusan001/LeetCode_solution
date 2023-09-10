class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode currentNode = head;
        while(currentNode != null){
            if(currentNode.val ==  val){
                pre.next = currentNode.next;
            }
            else{
                pre = currentNode;
            }
            currentNode = currentNode.next;
        }
        return dummyHead.next;
    }
}
