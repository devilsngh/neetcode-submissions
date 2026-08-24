class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[] {nums[i], i});
            if (i >= k - 1) {
                while (pq.peek()[1] <= i - k) {
                    pq.poll();
                }
                output[idx++] = pq.peek()[0];
            }
        }

        return output;
    }
}
