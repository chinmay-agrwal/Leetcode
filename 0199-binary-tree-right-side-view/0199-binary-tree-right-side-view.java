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

    public void recursive(TreeNode root, int level, ArrayList<Integer> ans){
        if (root == null) {
            return;
        }

        if (level == ans.size()) {
            ans.add(root.val);
        }

        recursive(root.right, level+1, ans);
        recursive(root.left, level+1, ans);

        return;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        recursive(root, 0, ans);
        return ans;
    }
}