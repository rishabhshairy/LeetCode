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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int[] arr = new int[1];
        solve(root, arr);
        return arr[0];
    }

    private void solve(TreeNode root, int[] arr) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
             if (root.left.left == null && root.left.right == null) {
                int sum = arr[0];
                sum += root.left.val;
                arr[0] = sum;
            }
            
        }
        solve(root.left, arr);
        solve(root.right, arr);
    }
    
}
