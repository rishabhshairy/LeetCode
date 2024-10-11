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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        Stack<Stack<Integer>> allNodes = new Stack<>();

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Stack<Integer> nodeStack = new Stack<>();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQueue.poll();
                nodeStack.push(currNode.val);

                if (currNode.left != null) {
                    nodeQueue.offer(currNode.left);
                }

                if (currNode.right != null) {
                    nodeQueue.offer(currNode.right);
                }
            }
            allNodes.add(nodeStack);
        }
        while (!allNodes.isEmpty()) {
            result.add(allNodes.pop());
        }
        return result;
    }
}
