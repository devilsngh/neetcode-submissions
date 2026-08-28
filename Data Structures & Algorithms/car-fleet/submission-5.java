class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int n = speed.length;

        for (int i = 0; i < n; i++) {
            list.add(new int[] {position[i], speed[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(b[0], a[0]));

        double prevTime = (double) (target - list.get(0)[0]) / list.get(0)[1];
        int fleet = 1;

        for (int i = 1; i < n; i++) {
            double currTime = (double) (target - list.get(i)[0]) / list.get(i)[1];
            if (currTime > prevTime) {
                prevTime = currTime;
                fleet++;
            }
        }

        return fleet;
    }
}
