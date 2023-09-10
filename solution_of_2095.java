class Solution {
    public ListNode deleteMiddle(ListNode head) {
        //遍历一遍链表获取元素个数
        int size = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            size++;
        }
        if(size == 1) return null;
        //删除中间元素
        int middle = size/2 - 1;
        curr = head;
        while(middle-- > 0){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
