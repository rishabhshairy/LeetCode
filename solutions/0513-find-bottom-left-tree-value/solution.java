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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        int leftMost = -1;

        while (!nodeQueue.isEmpty()) {
            TreeNode currNode = nodeQueue.poll();
            leftMost = currNode.val;

            if (currNode.right != null) {
                nodeQueue.offer(currNode.right);
            }
            if (currNode.left != null) {
                nodeQueue.offer(currNode.left);
            }

        }
        return leftMost;
    }
}
