/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        
        RandomListNode cur = pHead;
        while(cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = cur.next.next;
        }
        cur = pHead;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode ans = pHead.next;
        RandomListNode pCur = ans;
        while(cur != null) {
            cur.next = cur.next.next;
            if(pCur.next != null) pCur.next = pCur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return ans;
    }
}