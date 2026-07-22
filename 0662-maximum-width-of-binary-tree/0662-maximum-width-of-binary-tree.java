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

class Pair{

    TreeNode node;
    long index;

    Pair(TreeNode node, long index){
        this.node = node;
        this.index = index;
    }
}

class Solution {
    int maxi = 0;
    public int widthOfBinaryTree(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            
            int size = q.size();
            long count = 0;
            long j = 0;
            long k = 0;
            long min = q.peek().index;

            for(int i=0; i<size; i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                long ind = curr.index - min;

                if (i == 0) {
                    j = curr.index;
                }
                if(i == size-1){
                    k = curr.index;
                }

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2*ind + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, 2*ind + 2));
                }
                
            }
            count = k-j + 1;
            maxi = Math.max(maxi, (int)count);
        }
        return maxi;
    }
}