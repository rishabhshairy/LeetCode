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
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> allPaths = new ArrayList<List<Integer>>();
		List<Integer> currPath = new ArrayList<Integer>();

		solve(root, targetSum, currPath, allPaths);
        return allPaths;
	}

	private void solve(TreeNode node, int targetSum, List<Integer> currPath,
		    List<List<Integer>> allPaths) {
		if (node == null) {
			return;
		}
        currPath.add(node.val);
		if (node.left == null && node.right == null && targetSum == node.val) {
			allPaths.add(new ArrayList<Integer>(currPath));
		} else {
            solve(node.left, targetSum - node.val, currPath, allPaths);
            solve(node.right, targetSum - node.val, currPath, allPaths);
        }

		currPath.remove(currPath.size()-1);

	}
}
