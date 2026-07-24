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

    public TreeNode find(TreeNode root, int val){

        if(root == null)
            return null;

        if(root.val == val)
            return root;

        TreeNode left = find(root.left, val);

        if(left != null)
            return left;

        return find(root.right, val);
    }

    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

    }

    public int amountOfTime(TreeNode root, int target) {
        
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);

        HashSet<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode k = find(root, target);

        q.offer(k);
        vis.add(k);
        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++){

                TreeNode curr = q.poll();

                if (curr.left != null && !vis.contains(curr.left)) {
                    vis.add(curr.left);
                    q.offer(curr.left);
                }
                if (curr.right != null && !vis.contains(curr.right)) {
                    vis.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = parentMap.get(curr);

                if (parent != null && !vis.contains(parent)) {
                    vis.add(parent);
                    q.offer(parent);
                }

            }
            time++;
        }

        return time;
    }
}