class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            int dist = x * x + y * y;
            pq.offer(new int[] {dist, x, y});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (pq.size() > 0) {
            int[] temp = pq.poll();
            result[i++] = new int[] {temp[1], temp[2]};
        }

        return result;
    }
}
