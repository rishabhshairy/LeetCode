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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = {0, -1};
        solve(root, k, res);
        return res[1];
    }

    private void solve(TreeNode root, int k, int[] res) {
        if (root == null) {
            return;
        }
        solve(root.left, k, res);
        res[0] += 1;
        if (res[0] == k) {
            res[1] = root.val;
            return;
        }
        solve(root.right, k, res);
        return;
    }
}
