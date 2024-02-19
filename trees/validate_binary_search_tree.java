/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean dfs(TreeNode node, long lft, long rht) {
        if (node == null) {
            return true;
        }
        if (!(node.val < rht && node.val > lft)) {
            return false;
        }
        return (dfs(node.left, lft, node.val) && dfs(node.right, node.val, rht));
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}