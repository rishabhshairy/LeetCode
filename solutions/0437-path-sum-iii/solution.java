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

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        final Map<Long, Integer> sumCount = new HashMap<>();
        solve(root, targetSum, 0, sumCount);
        return count;
    }

    private void solve(TreeNode node, int targetSum, long currSum, Map<Long, Integer> sumCount) {
        if (node == null) {
            return;
        }
        currSum += node.val;
        if (targetSum == currSum) {
            count++;
        }

        count += sumCount.getOrDefault(currSum - targetSum, 0);
        sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);

        solve(node.left, targetSum, currSum, sumCount);
        solve(node.right, targetSum, currSum, sumCount);

        sumCount.put(currSum, sumCount.get(currSum) - 1);
    }
}
