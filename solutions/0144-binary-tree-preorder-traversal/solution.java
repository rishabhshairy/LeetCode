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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        traversePreOrder(root, preOrderList);
        return preOrderList;
    }

    private static void traversePreOrder(TreeNode root, List<Integer> preOrderList) {

        if (root == null) {
            return;
        }

        preOrderList.add(root.val);
        traversePreOrder(root.left, preOrderList);
        traversePreOrder(root.right, preOrderList);
    }
}
