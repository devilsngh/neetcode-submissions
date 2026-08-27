class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pair = stack.pop();
                ans[pair[1]] = i - pair[1];
            }


            stack.push(new int[] { temperatures[i], i});
        }

        return ans;
    }
}
