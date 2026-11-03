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
        helper(root.left, root.right, 1);
        return root;
    }
    public void helper(TreeNode left, TreeNode right, int depth){
        if(left==null || right ==null)return;
        if(depth%2!=0){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        helper(left.left, right.right, depth+1);
        helper(left.right, right.left, depth+1);
    }
}