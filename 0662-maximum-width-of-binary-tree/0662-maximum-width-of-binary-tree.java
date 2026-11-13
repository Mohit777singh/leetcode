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
    public int widthOfBinaryTree(TreeNode root) {
        long ans = 0;
        if(root==null) return 0;
        Queue<Pair<TreeNode , Long>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0L));
        while(!q.isEmpty()){
            int size = q.size();
            long first=0,last=0;
            long min = q.peek().getValue();
            for(int i =0;i<size; i++){
                Pair<TreeNode, Long> p = q.poll();
                TreeNode curr = p.getKey();
                long currId = p.getValue()-min;
                if(i==0) first = currId;
                if(i==size-1) last = currId;
                if(curr.left!=null){
                    q.offer(new Pair<>(curr.left,currId*2+1));
                }
                if(curr.right!=null){
                    q.offer(new Pair<>(curr.right, currId*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return (int) ans;
    }
}