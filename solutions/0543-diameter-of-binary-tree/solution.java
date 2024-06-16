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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int withRoot = height(root.left) + height(root.right);
        int leftToRoot = diameterOfBinaryTree(root.left);
        int rightToRoot = diameterOfBinaryTree(root.right);
        return Math.max(withRoot,Math.max(leftToRoot,rightToRoot));
    }
    public int height(TreeNode root){
       if (root==null){
            return 0;
        }
       if(root.left==null &&  root.right==null){
            return 1;
        }
        int leftCount=height(root.left);
        int rightCount=height(root.right);
        return 1 + Math.max(leftCount,rightCount);
    }
    
}
