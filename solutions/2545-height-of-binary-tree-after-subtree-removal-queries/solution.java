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
    int[] allHeight = new int[100001];
    int[] leftHeight = new int[100001];
    int[] rightHeight = new int[100001];

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] result = new int[queries.length];

        findHeight(root);

        solve(root.left, rightHeight[root.val], 1);
        solve(root.right, leftHeight[root.val], 1);

        for (int i = 0; i < queries.length; i++) {
            result[i] = allHeight[queries[i]];
        }
        return result;
    }

    private void solve(TreeNode node, int currMax, int depth) {
        if (node == null) {
            return;
        }

        allHeight[node.val] = currMax;
        solve(node.left, Math.max(currMax, depth + rightHeight[node.val]), depth + 1);
        solve(node.right, Math.max(currMax, depth + leftHeight[node.val]), depth + 1);
    }

    private int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        leftHeight[root.val] = left;
        rightHeight[root.val] = right;

        return 1 + Math.max(left, right);
    }
}
