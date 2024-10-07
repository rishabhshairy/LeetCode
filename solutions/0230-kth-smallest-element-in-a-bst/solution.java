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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] smallest = new int[1];
        findSmallest(root, count, smallest, k);
        return smallest[0];
    }

    private void findSmallest(TreeNode node, int[] count, int[] smallest, int k) {
        if (node == null) {
            return;
        }

        findSmallest(node.left, count, smallest, k);
        count[0]++;
        if (count[0] == k) {
            smallest[0] = node.val;
            return;
        }
        findSmallest(node.right, count, smallest, k);
    }
}
