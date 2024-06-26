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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        traverse(root, answer);
        return answer;
    }

    private static void traverse(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return;
        }
        answer.add(root.val);
        traverse(root.left, answer);
        traverse(root.right, answer);
    }
}
