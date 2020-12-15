/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null) return null;
        if(k == 0) return null;

        ListNode cur1 = head;
        ListNode cur2 = head;
        for(int i = 0; i < k - 1; i++) {
            if(cur1.next != null) cur1 = cur1.next;
            else return null;
        }
        while(cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2;
    }
}