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

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        int ans = 1 + Math.max(left, right);

        return ans;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        int ans = left + right;

        int ans1 = diameterOfBinaryTree(root.left);
        int ans2 = diameterOfBinaryTree(root.right);

        return Math.max(ans,Math.max(ans1, ans2));
    }
}