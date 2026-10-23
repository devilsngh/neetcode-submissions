class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (int task : tasks) {
            counter[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Queue<int[]> q = new LinkedList<>();

        for (int count : counter) {
            if (count > 0) pq.offer(count);
        }

        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = pq.poll() - 1;
                if (cnt > 0) q.offer(new int[] {cnt, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }
        }

        return time;
    }
}
