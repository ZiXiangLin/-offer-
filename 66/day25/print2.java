import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

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
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        if(pRoot == null) return ans;
        boolean reverse = true;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = pRoot;
        queue.offer(node);
        while(!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> elem = new ArrayList<>();
            Queue<Integer> elem_queue = new LinkedList<>();
            Stack<Integer> elem_stack = new Stack<>();
            for(int i = 0; i < length; i++) {
                node = queue.poll();
                
                if(reverse) elem_queue.offer(node.val);
                else elem_stack.push(node.val);
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(reverse) {
                while(!elem_queue.isEmpty()) {
                    elem.add(elem_queue.poll());
                }
                reverse = false;
            }else {
                while(!elem_stack.isEmpty()) {
                    elem.add(elem_stack.pop());
                }
                reverse = true;
            }
            ans.add(elem);
        }
        return ans;
    }

}