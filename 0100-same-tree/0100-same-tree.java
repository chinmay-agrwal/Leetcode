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

    public void preOrder(TreeNode root, ArrayList<Integer> list){
        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);

        return;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        ArrayList<Integer> tree1 = new ArrayList<>();
        ArrayList<Integer> tree2 = new ArrayList<>();

        preOrder(p, tree1);
        preOrder(q, tree2);

        return tree1.equals(tree2);
    }
}