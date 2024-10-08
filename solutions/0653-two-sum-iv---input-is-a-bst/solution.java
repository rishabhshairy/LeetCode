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

    static class BSTIterator {
        protected Stack<TreeNode> nodeStack = new Stack<>();
        protected boolean reverseInorder = true;
        public BSTIterator(TreeNode root, Boolean isReverse) {
            reverseInorder = isReverse;
            pushAll(root);
        }

        boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        int next() {
            TreeNode node = nodeStack.pop();
            if (reverseInorder==false) {
                pushAll(node.right);
            } else {
                pushAll(node.left);
            }
            return node.val;
        }

        private void pushAll(TreeNode node) {
            while (node != null) {
                nodeStack.push(node);
                if (reverseInorder) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
    }

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        BSTIterator iterator = new BSTIterator(root, false);
        BSTIterator reverseIterator1 = new BSTIterator(root, true);

        int leftPointer = iterator.next();
        int rightPointer = reverseIterator1.next();
        while (leftPointer < rightPointer) {
            int sum = leftPointer + rightPointer;
            if (sum < k) {
                if (iterator.hasNext()) {
                    leftPointer = iterator.next();
                }
            } else if (sum > k) {
                if (reverseIterator1.hasNext()) {
                    rightPointer = reverseIterator1.next();
                }
            } else if (sum == k) {
                return true;
            }
        }
        return false;
    }
}
