// Source: https://leetcode.com/problems/balanced-binary-tree/

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
    private boolean isBal = true;

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (Math.abs(left - right) > 1) {
            isBal = false;
        }
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBal;
    }
}