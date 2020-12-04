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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = new ListNode(0);
        pre.next = cur;
        int upTo10 = 0;
        while(l1 != null || l2 != null) {
            int temp = ((l1 != null)? l1.val : 0) + ((l2 != null) ? l2.val : 0) + upTo10;
            if(temp >= 10) {
                upTo10 = 1;
                temp -= 10;
            } else upTo10 = 0;
            ListNode node = new ListNode(temp);
            cur.next = node;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        if(upTo10 == 1) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return pre.next.next;
    }
}