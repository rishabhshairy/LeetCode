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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        if (root == null) {
            return postOrderList;
        }

        Stack<TreeNode> opStack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();
        opStack.push(root);

        while (!opStack.isEmpty()) {
            root = opStack.pop();
            if (root.left != null) {
                opStack.push(root.left);
            }

            if (root.right != null) {
                opStack.push(root.right);
            }
            postOrderList.add(root.val);
        }
        Collections.reverse(postOrderList);
        return postOrderList;
    }
}
