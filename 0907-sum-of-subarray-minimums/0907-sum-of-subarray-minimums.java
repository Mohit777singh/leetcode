class Solution {

    private int[] previousLess(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        return left;
    }

    private int[] nextLessEqual(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        return right;
    }

    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        long MOD = (int)(1e9 + 7);

        int[] left = previousLess(arr);
        int[] right = nextLessEqual(arr);

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            long contribution =
                (long) arr[i] * leftCount * rightCount;

            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}