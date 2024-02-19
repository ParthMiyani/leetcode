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
    private int preStart = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart++]);
        if (inStart == inEnd) {
            return root;
        }
        int mid = inStart;
        for (int i = mid; i <= inEnd; i++) {
            if (inOrder[i] == root.val) {
                mid = i;
                break;
            }
        }
        root.left = helper(preOrder, inOrder, inStart, mid - 1);
        root.right = helper(preOrder, inOrder, mid + 1, inEnd);
        return root;
    }
}