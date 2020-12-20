/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 左-中-右
        if(pRootOfTree == null) return null;
        TreeNode cur = pRootOfTree;
        TreeNode pre = pRootOfTree;
        boolean isFirst = true;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || (!stack.isEmpty())) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(isFirst) {
                pRootOfTree = cur; // let pRootOfTree point to min
                pre = pRootOfTree;
                isFirst = false;
            }else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
        return pRootOfTree;
    }
}