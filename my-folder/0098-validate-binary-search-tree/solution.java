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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return solve(root, null, null);
    }

    private boolean solve(TreeNode root, Integer minValue, Integer maxVal) {
        if (root == null) {
            return true;
        }
        if ((minValue != null && root.val <= minValue) || (maxVal != null && root.val >= maxVal)) {
            return false;
        }
        return solve(root.left, minValue, root.val) && solve(root.right, root.val, maxVal);
    }
}
