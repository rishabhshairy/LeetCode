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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int[] arr = new int[1];
        solve(root, arr, root.val);
        return arr[0];
    }

    private void solve(TreeNode root, int[] arr, int val) {
        if (root == null) {
            return;
        }

        if (root.val >= val) {
            arr[0]++;
        }
        solve(root.left, arr, Math.max(val, root.val));
        solve(root.right, arr, Math.max(val, root.val));
    }
}
