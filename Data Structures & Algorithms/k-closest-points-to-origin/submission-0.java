class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) -> {
            int dist1 = a[0] * a[0] + a[1] * a[1];
            int dist2 = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(dist1, dist2); 
        });

        return Arrays.copyOfRange(points, 0, k);
    }
}
