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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return  null;
        }

        TreeNode left = invertTree(root.left); // recursively find the tree
        TreeNode right = invertTree(root.right); // recursively find the tree on right
         
        root.right = left;
        root.left = right;
        
        return root;

    }
}
