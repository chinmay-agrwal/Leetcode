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

    public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++){

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
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParent(root, parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);
        int dist = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                break;
            }

            dist++;

            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                TreeNode parent = parentMap.get(curr);

                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    q.offer(parent);
                }
            }
        }

        return ans;
    }
}