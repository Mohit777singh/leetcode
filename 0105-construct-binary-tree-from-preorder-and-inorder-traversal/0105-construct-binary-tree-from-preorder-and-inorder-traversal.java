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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp =new HashMap<>();
        for(int i =0; i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root = helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,mp);
        return root;
    }
    public TreeNode helper(int[] preorder, int preSrt, int preEnd, int[] inorder, int inSrt, int inEnd, Map<Integer,Integer> mp){
        if(preSrt>preEnd || inSrt>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preSrt]);
        int inRoot = mp.get(root.val);
        int numLeft = inRoot - inSrt;
        root.left = helper(preorder, preSrt+1,preSrt + numLeft,inorder,inSrt,inRoot-1,mp);
        root.right = helper(preorder,preSrt+numLeft+1,preEnd,inorder,inRoot+1,inEnd,mp);
        return root;
    }
    
}