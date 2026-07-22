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

    public boolean dfs(TreeNode root, ArrayList<Integer> list, TreeNode x){
        if (root == null) {
            return false;
        }

        list.add(root.val);

        if (root.val == x.val) {
            return true;
        }
        if (dfs(root.left, list, x) || dfs(root.right, list, x)) {
            return true;
        }

        list.remove(list.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        dfs(root, list1, p);
        dfs(root, list2, q);

        int i = 0;
        int ind = 0;
        
        while (i < list1.size() && i <list2.size()) {
            if (list1.get(i).equals(list2.get(i))) {
                ind = i;
                i++;
            }
            else{
                break;
            }
        }

        return new TreeNode(list1.get(ind));
    }
}