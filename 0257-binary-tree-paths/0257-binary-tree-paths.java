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
        
        List<String> ans = new ArrayList<>();

        dfs(root, ans, "");

        return ans;
    }

    public void dfs(TreeNode root, List<String> ans, String path){
        if (root == null) {
            return;
        }

        if(path.length() == 0){
            path = String.valueOf(root.val);
        }
        else{
            path = path + "->" + root.val;
        }

        if(root.left == null && root.right == null){
            ans.add(path);
            return;
        }

        dfs(root.left, ans, path);
        dfs(root.right, ans, path);
    }
}