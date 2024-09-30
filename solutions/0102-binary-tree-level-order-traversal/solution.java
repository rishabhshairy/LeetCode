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
    public List<List<Integer>> levelOrder(TreeNode root) {
                List<List<Integer>> levelList = new ArrayList<>();
        if (root == null) {
            return levelList;
        }

        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int levelNum = nodeQueue.size();
            List<Integer> levelNodeList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                // check for left and right child
                if (nodeQueue.peek().left != null) {
                    nodeQueue.offer(nodeQueue.peek().left);
                }
                if (nodeQueue.peek().right != null) {
                    nodeQueue.offer(nodeQueue.peek().right);
                }
                levelNodeList.add(nodeQueue.poll().val);
            }
            levelList.add(levelNodeList);
        }
        return levelList;
    }
}
