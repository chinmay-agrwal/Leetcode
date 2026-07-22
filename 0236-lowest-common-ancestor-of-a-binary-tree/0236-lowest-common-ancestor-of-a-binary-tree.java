/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean dfs(TreeNode root, ArrayList<TreeNode> list, TreeNode target){
        if (root == null) {
            return false;
        }

        list.add(root);

        if (root.val == target.val) {
            return true;
        }

        if (dfs(root.left, list, target) || dfs(root.right, list, target)) {
            return true;
        }

        list.remove(list.size()-1);

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        dfs(root, list1, p);
        dfs(root, list2, q);

        int i = 0;

        while (i<list1.size() && i<list2.size()) {
            if (list1.get(i).equals(list2.get(i))) {
                i++;
            }
            else{
                break;
            }
        }

        return list1.get(i-1);
    }
}