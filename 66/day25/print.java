import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        if(pRoot == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = pRoot;
        queue.offer(node);
        while(!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> elem = new ArrayList<>();
            for(int i = 0; i < length; i++) {
                node = queue.poll();
                elem.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(elem);
        }
        return ans;
    }
    
}