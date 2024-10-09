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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        solveInorderSwap(root);

        // now swap first middle or first-last
        if (first != null && last != null) {
            swap(first, last);
        } else if (first != null && middle != null) {
            swap(first, middle);
        }
    }

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void solveInorderSwap(TreeNode root) {
        if (root == null) {
            return;
        }
        solveInorderSwap(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        solveInorderSwap(root.right);
    }
}
