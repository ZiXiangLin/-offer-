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