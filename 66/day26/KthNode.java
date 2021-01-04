import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        int count = 0;
        while( !stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            count++;
            if(count == k) return cur;
            cur = cur.right;
        }
        return null;
    }


}