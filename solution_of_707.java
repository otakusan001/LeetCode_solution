//单链表实现
public class ListNode {
    // 结点的值
    int val;
    // 下一个结点
    ListNode next;
    // 节点的构造函数(无参数)
    public ListNode(){};
    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }
}


class MyLinkedList {
    
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    public int get(int index) {
        if(index < 0 || size < index + 1) return -1; //索引非法
        ListNode current = head;
        while(index >= 0){
                current = current.next;
                index--;
            }
        return current.val;
    }
    
    public void addAtHead(int val) {
        ListNode addedNode = new ListNode(val);
        addedNode.next = head.next;
        head.next = addedNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode addedNode = new ListNode(val);
        ListNode current = head;
        int n = size;
        while(n-- > 0) current=current.next;
        addedNode.next = current.next;
        current.next = addedNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == size) {
            addAtTail(val);
        }
        else if(index < size){
            ListNode addedNode = new ListNode(val);
            ListNode current = head;
            int n = index - 1;
            while(n-- >= 0){
                current = current.next;
            }
            addedNode.next = current.next;
            current.next = addedNode;
            size++;
        }
        
    }
    
    public void deleteAtIndex(int index) {
        ListNode current = head;
        if(index >= 0 && index <= size -1){
            while(index-- > 0){
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }
}
