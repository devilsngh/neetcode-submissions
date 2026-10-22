class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Queue<int[]> q = new LinkedList<>();
        int[] counter = new int[26];
        for (char ch : tasks) {
            counter[ch - 'A']++;
        }

        for (int count : counter) {
            if (count > 0) pq.offer(count);
        }

        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int count = pq.poll() - 1;
                if (count > 0) q.offer(new int[] {count, time + n});
            }

            if (!q.isEmpty() && time == q.peek()[1]) {
                pq.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
