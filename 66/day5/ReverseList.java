/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        while(head != null) {
            int val = head.val;
            ListNode node = new ListNode(val);
            node.next = pre.next;
            pre.next = node;
            head = head.next;
        }
        return pre.next;
    }
}