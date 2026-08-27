class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int n = speed.length;
        for (int i = 0; i < n; i++) {
            list.add(new int[] {position[i], speed[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int[] p : list) {
            stack.push((double) (target - p[0]) / p[1]);

            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
