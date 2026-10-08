class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int num : nums){
            m.put(num, m.getOrDefault(num, 0)+1);
        }
        int cond = nums.length/2;
        int ans =0;
        for(int i :nums){
            if(m.get(i)>cond){
                ans= i;
                break;
            }
        }
        return ans;
    }
}