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

    public void rootRL(TreeNode root, ArrayList<Integer> ans){
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(root.val);
        rootRL(root.right, ans);
        rootRL(root.left, ans);

        return;
    }

    public void rootLR(TreeNode root, ArrayList<Integer> ans){
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(root.val);
        rootLR(root.left, ans);
        rootLR(root.right, ans);

        return;
    }

    public boolean isSymmetric(TreeNode root) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        rootLR(root.left, list1);
        rootRL(root.right, list2);

        System.out.println(list1);
        System.out.println(list2);
        if (list1.equals(list2)) {
            return true;
        }
        return false;
    }
}