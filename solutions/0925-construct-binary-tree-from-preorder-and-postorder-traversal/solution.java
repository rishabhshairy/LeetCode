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
    int index = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }

        return solve(0, postorder.length - 1, preorder, postorder, postMap);
    }

    private TreeNode solve(int start, int end, int[] preorder, int[] postorder,
            Map<Integer, Integer> postMap) {

        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);

        if (start == end) {
            return node;
        }

        // find index to split
        int splitIndex = postMap.get(preorder[index]);

        // left node should be till splitIndex
        node.left = solve(start, splitIndex, preorder, postorder, postMap);

        // right node should start from splitIndex
        node.right = solve(splitIndex + 1, end - 1, preorder, postorder,
                postMap);

        return node;
    }
}
