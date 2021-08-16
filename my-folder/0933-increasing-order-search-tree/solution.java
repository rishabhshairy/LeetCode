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
    TreeNode head;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode preCurr = new TreeNode(-1);
        head = preCurr;
        solve(root);
        return preCurr.right;
    }

    private void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.left);

        head.right = new TreeNode(root.val);
        head = head.right;
        
        solve(root.right);
    }
}
