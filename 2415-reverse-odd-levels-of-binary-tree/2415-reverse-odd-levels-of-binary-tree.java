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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int lvl=0;
        while(!q.isEmpty()){
            List<TreeNode> list = new LinkedList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                list.add(curr);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }

            if(lvl%2!=0){
                int left = 0;
                int right = list.size()-1;
                while(left<right){
                    int temp  = list.get(left).val;
                    list.get(left).val = list.get(right).val;
                    list.get(right).val =temp;
                    left++;
                    right--;
                }
            }
            lvl++;
        }
        return root;
    }
}