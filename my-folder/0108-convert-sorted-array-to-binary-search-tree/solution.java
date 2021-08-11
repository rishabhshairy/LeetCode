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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int midIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midIndex));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, midIndex + 1, nums.length));
        return root;
    }
}
