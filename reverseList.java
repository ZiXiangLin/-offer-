/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        while(head != null) {
            ListNode node = new ListNode(head.val);
            node.next = pre.next;
            pre.next = node;
            head = head.next;
        }
        return pre.next;
    }
}