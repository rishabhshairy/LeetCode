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
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] len = { 0 };
        return formTree(preorder, Integer.MAX_VALUE, len);
    }

    private TreeNode formTree(int[] preorder, int bound, int[] len) {
        if (len[0] == preorder.length || preorder[len[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[len[0]++]);
        root.left = formTree(preorder, root.val, len);
        root.right = formTree(preorder, bound, len);
        return root;
    }
}
