// Source: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur;

        // if (root == null) return null;
        // if (root.val > Math.max(p.val, q.val)) {
        // return lowestCommonAncestor(root.left, p, q);
        // } else if (root.val < Math.min(p.val, q.val)) {
        // return lowestCommonAncestor(root.right, p, q);
        // } else {
        // return root;
        // }
    }
}