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
    private static int sum;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        sum = 0;
        reverseInorder(root);
        return root;
    }

    private static void reverseInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        reverseInorder(node.right);
        int temp = node.val;
        node.val = sum+temp;
        sum += temp;

        reverseInorder(node.left);
    }
}
