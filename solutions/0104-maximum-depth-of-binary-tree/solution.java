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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        int level = 0;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                if (nodeQueue.peek().left != null) {
                    nodeQueue.offer(nodeQueue.peek().left);
                }
                if (nodeQueue.peek().right != null) {
                    nodeQueue.offer(nodeQueue.peek().right);
                }
                nodeQueue.poll();
            }
            level++;
        }
        return level;
    }
}
