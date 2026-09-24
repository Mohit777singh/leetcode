class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] ans =  new int[nums.length];
        int n = nums.length;
        for(int i = 2*n-1;i>=0;i--){
            int idx = i % n;
            while(!st.isEmpty() && st.peek()<=nums[idx]){
                st.pop();
            }
            if(i<n){
                if(st.isEmpty()){
                    ans[i]=-1;
                }
                else{
                    ans[i]=st.peek();
                }
            }
            st.push(nums[idx]);
        }
        return ans;
    }
}