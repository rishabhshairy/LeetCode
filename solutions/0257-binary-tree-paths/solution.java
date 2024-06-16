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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        
        String outRight = "";
        traverseRootToLeft(root, outRight, answer);
        
        return answer;
    }

    private static void traverseRootToLeft(TreeNode root, String outLeft, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(outLeft + root.val);
            return;
        }
        if(root.left != null){
          //  outLeft += 
            traverseRootToLeft(root.left, outLeft + root.val + "->", answer);
        }
        if(root.right != null){
          //  outLeft += root.val + "->";
            traverseRootToLeft(root.right, outLeft + root.val + "->", answer);
        }
        

    }

}
