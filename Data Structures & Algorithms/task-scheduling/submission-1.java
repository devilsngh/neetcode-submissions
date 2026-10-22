class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;

        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int temp : count) {
            if (temp > 0) pq.offer(temp);
        }

        Queue<int[]> q = new LinkedList<>();

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (pq.isEmpty()) {
                time = q.peek()[1];
            } else {
                int cnt = pq.poll() - 1;
                if (cnt > 0) q.add(new int[] {cnt, time + n});
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }
        }

        return time;
    }
}
