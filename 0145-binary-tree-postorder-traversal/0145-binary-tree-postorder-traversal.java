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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !st.isEmpty()) {

            if (curr != null) {

                st.push(curr);
                curr = curr.left;

            } else {

                TreeNode peek = st.peek();

                if (peek.right != null && lastVisited != peek.right) {

                    curr = peek.right;

                } else {

                    ans.add(peek.val);
                    lastVisited = st.pop();
                }
            }
        }

        return ans;
    }
}