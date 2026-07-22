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

        if (list1.contains(q.val)) {
            return q;
        }
        if (list2.contains(p.val)) {
            return p;
        }
        else{
            if (list1.size() <= list2.size()) {
                for(int i=list1.size()-1; i>=0; i--){
                    if (list2.contains(list1.get(i))) {
                        return new TreeNode(list1.get(i));
                    }
                }
            }
            for(int i=list2.size()-1; i>=0; i--){
                if (list1.contains(list2.get(i))) {
                    return new TreeNode(list2.get(i));
                }
            }
        }

        return p;
    }
}