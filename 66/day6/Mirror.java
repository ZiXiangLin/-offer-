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
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left == null) {
            root.left = root.right;
            root.right = null;
        }else if(root.right == null) {
            root.right = root.left;
            root.left = null;
        }else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        Mirror(root.left);
        Mirror(root.right);
    }
}