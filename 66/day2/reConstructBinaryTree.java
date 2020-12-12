/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        int root_val = pre[0];
        TreeNode root = new TreeNode(root_val);
        int index = 0;
        for(; index < in.length; index++) {
            if(in[index] == root_val) break;
        }
        root.left = helper(pre, in, 1, index, index);
        root.right = helper(pre, in, index + 1, pre.length - 1, index);
        return root;
    }
    public TreeNode helper(int[] pre, int[] in, int pre_head, int pre_tail, int in_last) {
        if(pre_head == pre_tail) return new TreeNode(pre[pre_head]);
        if(pre_head > pre_tail) return null;
        // sort nums in pre[head->tail]
        // in_last: last time the scope index in in
        // pre [1,2,3,4,5,6,7]
        // in[3,2,4,1,6,5,7]
        // in_last : index of 1 in [in] : 3
        // pre_head -> pre_tail: index of unsettled in [pre] : 1->3
        int root_val = pre[pre_head];
        TreeNode node = new TreeNode(root_val);
        // 找到root_val 在[in]中的下标
        int in_index = 0;
        for(; in_index < in.length; in_index++) {
            if(in[in_index] == root_val) break;
        }
        if(in_index < in_last) {
            // 在上一次切的刀的左侧， 两个下标差值减一 即右侧的子树节点数目
            int right_num = in_last - in_index - 1;
            int left_num = (pre_tail - pre_head) - right_num;
            node.left = helper(pre, in, pre_head + 1, pre_head + left_num, in_index);
            node.right = helper(pre, in, pre_head + left_num + 1, pre_tail, in_index);
        }else {
            // 在上一次切的刀的右侧, 两个下标差值减一 即左侧的子树节点数目
            int left_num = in_index - in_last - 1;
            node.left = helper(pre, in, pre_head + 1, pre_head + left_num, in_index);
            node.right = helper(pre, in, pre_head + left_num + 1, pre_tail, in_index);
        }
        return node;
    }
}