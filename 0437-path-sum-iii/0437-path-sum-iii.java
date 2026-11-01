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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        return count(root,0L,targetSum, map);
    }
    int count(TreeNode root, long sum, int target, Map<Long, Integer> map){
        if(root==null) return 0;
        sum+=root.val;
        int cnt = map.getOrDefault(sum-target, 0);
        map.put(sum,map.getOrDefault(sum, 0) +1 );
        cnt += count(root.left, sum, target, map);
        cnt += count(root.right, sum, target, map);
        map.put(sum, map.get(sum) -1);
        return cnt;
    }
}