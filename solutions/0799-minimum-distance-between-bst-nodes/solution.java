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
    TreeNode prev = null;
    
    public int minDiffInBST(TreeNode root) {
        int[] mini = {Integer.MAX_VALUE};
        solve(root, mini);
        return mini[0];
    }

    private void solve(TreeNode root, int[] mini) {
        if (root == null) {
            return;
        }
        solve(root.left, mini);
        if (prev != null) {
            int diff = root.val - prev.val;
            mini[0] = Math.min(mini[0], diff);
        }
        prev = root;
        solve(root.right, mini);
    }
}
