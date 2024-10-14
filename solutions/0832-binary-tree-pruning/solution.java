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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return solve(root);
    }

    private static TreeNode solve(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = solve(node.left);
        node.right = solve(node.right);

        if (node.val == 0 && node.left == null && node.right == null) {
            return null;
        }

        return node;
    }
}
