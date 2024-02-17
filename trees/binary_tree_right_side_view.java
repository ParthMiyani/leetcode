import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        dq.addLast(root);

        while (!dq.isEmpty()) {
            int len = dq.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = dq.removeFirst();
                if (i == len - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    dq.addLast(cur.left);
                }
                if (cur.right != null) {
                    dq.addLast(cur.right);
                }
            }
        }

        return res;
    }

    // public List<Integer> rightSideView(TreeNode root) {
    // List<Integer> ans = new ArrayList<>();
    // helper(root, ans, 0);
    // return ans;
    // }
    // private void helper(TreeNode root, List<Integer> ans, int depth){
    // if(root == null){
    // return;
    // }
    // if(depth == ans.size()){
    // ans.add(root.val);
    // }
    // helper(root.right, ans, depth+1);
    // helper(root.left, ans, depth+1);
    // }
}