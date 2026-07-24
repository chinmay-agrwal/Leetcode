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

    public TreeNode markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap, int target, TreeNode k){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            
            TreeNode curr = q.poll();

            if (curr.val == target) {
                k = curr;
            }

            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return k;
    }

    public int amountOfTime(TreeNode root, int target) {
        
        TreeNode k = null;

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        k = markParent(root, parentMap, target, k);

        HashSet<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

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