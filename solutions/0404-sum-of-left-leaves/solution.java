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
    static boolean leftMovement = true;
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = {0};
        solve(root, sum);
        return sum[0];
    }

    private static void solve(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && leftMovement) {
            sum[0] += node.val;
        }
        leftMovement = true;
        solve(node.left, sum);
        leftMovement = false;
        solve(node.right, sum);
    }
}
