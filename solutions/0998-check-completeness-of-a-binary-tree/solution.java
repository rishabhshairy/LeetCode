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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (nodeQueue.peek() != null) {
            TreeNode currNode = nodeQueue.poll();
            nodeQueue.offer(currNode.left);
            nodeQueue.offer(currNode.right);
        }
        // System.out.println(nodeQueue);
        while (!nodeQueue.isEmpty() && nodeQueue.peek() == null) {
            nodeQueue.poll();
        }
        return nodeQueue.isEmpty();
    }
}
