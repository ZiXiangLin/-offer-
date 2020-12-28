public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) return true;
        int lengthL = TreeDepth(root.left);
        int lengthR = TreeDepth(root.right);
        if( Math.abs(lengthR - lengthL) > 1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int left = getDepth(root.left);
        if(left == -1) return -1;
        int right = getDepth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}