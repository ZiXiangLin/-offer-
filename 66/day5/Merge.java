/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode pre = new ListNode(0);
        ListNode cur = new ListNode(0);
        pre.next = cur;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ListNode node = new ListNode(list1.val);
                cur.next = node;
                cur = cur.next;
                list1 = list1.next;
            }else {
                ListNode node = new ListNode(list2.val);
                cur.next = node;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        while(list1 != null) {
            ListNode node = new ListNode(list1.val);
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
        }
        while(list2 != null) {
            ListNode node = new ListNode(list2.val);
            cur.next = node;
            cur = cur.next;
            list2 = list2.next;
        }

        return pre.next.next;
    }
}