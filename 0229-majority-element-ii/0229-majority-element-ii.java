class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num : nums){
            m.put(num, m.getOrDefault(num, 0 )+1);
        }
        int cond = nums.length /3;
        for(int i : m.keySet()){
            if(m.get(i)>cond){
                ans.add(i);
            }
        }
        return ans;
    }
}