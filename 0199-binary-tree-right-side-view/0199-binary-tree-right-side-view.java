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
    public List<Integer> rightSideView(TreeNode root) {
        // if(root==null) return;
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }
    void dfs(TreeNode root, int depth, ArrayList<Integer> ans){
        if(root==null) return;
        if(ans.size()==depth){
            ans.add(root.val);
        }
        dfs(root.right, depth+1, ans);
        dfs(root.left, depth+1, ans);
    }
}