import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        ArrayList<Integer> elem = new ArrayList<>();
        backtrack(root, target, ans, elem);
        
        return ans;
        
    }
    public void backtrack(TreeNode node, int target,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> elem) {
        if(node == null || node.val > target) return;
        if(node.left == null && node.right == null) {
            if(node.val == target && !(ans.contains(elem))) {
               elem.add(node.val);
               ans.add(new ArrayList<>(elem));
               elem.remove(elem.size() - 1);
            } else return;
        }
        elem.add(node.val);
        backtrack(node.left, target - node.val, ans, elem);
        backtrack(node.right, target - node.val, ans, elem);
        elem.remove(elem.size() - 1);
    }
}