// Source: https://leetcode.com/problems/maximum-depth-of-binary-tree/
package trees;

import java.util.LinkedList;
import java.util.Queue;

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
    // recursive dfs solution - main
    // public int maxDepth(TreeNode root) {
    // if (root == null) {
    // return 0;
    // }

    // int left = maxDepth(root.left);
    // int right = maxDepth(root.right);

    // return Math.max(left, right) + 1;
    // }

    // iterative bfs solution
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;

        while (!q.isEmpty()) {
            int lenofQ = q.size();
            for (int i = 0; i < lenofQ; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res += 1;
        }
        return res;
    }
}