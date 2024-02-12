// Source: https://leetcode.com/problems/diameter-of-binary-tree/
package trees;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int res = 0;

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxLeft = dfs(node.left);
        int maxRight = dfs(node.right);
        res = Math.max(res, (maxLeft + maxRight));

        return 1 + Math.max(maxLeft, maxRight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }
}