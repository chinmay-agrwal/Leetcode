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

    public boolean isSymmetricHelp(TreeNode leftRoot, TreeNode rightRoot){
        if (leftRoot == null || rightRoot == null) {
            return leftRoot==rightRoot;
        }

        if (leftRoot.val != rightRoot.val) {
            return false;
        }

        boolean ans = isSymmetricHelp(leftRoot.left, rightRoot.right) && isSymmetricHelp(leftRoot.right, rightRoot.left);
        return ans;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }
}