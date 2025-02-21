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
class FindElements {

    Set<Integer> treeValSet = new HashSet<>();

    public FindElements(TreeNode root) {
        
        if (root != null && root.val == -1) {
            root.val = 0;
            treeValSet.add(0);
        }

        recover(root);
       
    }

    public void recover(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            treeValSet.add(node.left.val);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            treeValSet.add(node.right.val);
            // System.out.println(treeValSet);
        }
        recover(node.left);
        recover(node.right);
    }

    public boolean find(int target) {
        return treeValSet.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
