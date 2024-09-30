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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                nodeStack.push(node);
                node = node.left;
            } else {
                if (nodeStack.isEmpty()) {
                    break;
                }
                node = nodeStack.pop();
                inorderList.add(node.val);
                node = node.right;
            }
        }
        return inorderList;
    }
}
