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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        boolean directionFlag = true;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            Integer[] levelList = new Integer[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                // below logic handles the direction of insertion into the list
                int index = directionFlag ? i : (size - 1 - i);
                levelList[index] = node.val;

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }

            directionFlag = !directionFlag;
            result.add(Arrays.asList(levelList));
        }
        return result;
    }
}
