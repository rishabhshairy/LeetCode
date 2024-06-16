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
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<String> path = new ArrayList<>();
        String pathStr = "";
        int sum = 0;
        solve(root, pathStr, path);
        for (String binaryNum :
                path) {
            sum += Integer.valueOf(binaryNum, 2);
        }
        return sum;
    }

    private void solve(TreeNode root, String pathStr, ArrayList<String> path) {
        if (root.left == null && root.right == null) {
            pathStr += root.val;
            path.add(pathStr);
            pathStr = "";
        }
        pathStr += root.val;
        if (root.left != null) {
            solve(root.left, pathStr, path);
        }
        if (root.right != null) {
            solve(root.right, pathStr, path);
        }

    }
}
