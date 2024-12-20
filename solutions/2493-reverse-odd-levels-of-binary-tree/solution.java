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
    public TreeNode reverseOddLevels(TreeNode root) {
                if (root == null) {
            return root;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int level = 0;

        while (!nodeQueue.isEmpty()) {
            int levelNum = nodeQueue.size();
            while (levelNum-- > 0) {
                TreeNode currNode = nodeQueue.poll();
                if (currNode.left!=null){
                    nodeQueue.offer(currNode.left);
                }
                if (currNode.right!=null){
                    nodeQueue.offer(currNode.right);
                }
            }
            level++;
            // now reverse the values in LL
            if (level % 2 == 1 && !nodeQueue.isEmpty()) {
                int[] nodeVals = new int[nodeQueue.size()];

                // add all value
                int i = 0;
                for (TreeNode node : nodeQueue) {
                    nodeVals[i++] = node.val;
                }

                // reverse node vals in queue
                int j = nodeQueue.size() - 1;
                for (TreeNode node : nodeQueue) {
                    node.val = nodeVals[j--];
                }
            }
        }

        return root;
    }
}
