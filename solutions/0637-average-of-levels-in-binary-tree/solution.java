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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        solve(root, answer);
        return answer;
    }

    private void solve(TreeNode root, List<Double> answer) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            Double sum = 0d;
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = nodeQueue.poll();
                sum += temp.val;

                if (temp.left != null) {
                    nodeQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    nodeQueue.offer(temp.right);
                }
            }
            answer.add(sum/size);
        }
    }
}
