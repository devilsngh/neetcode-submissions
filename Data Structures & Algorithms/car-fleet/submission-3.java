class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> list = new ArrayList<>();
        int n = speed.length;

        for (int i = 0; i < n; i++) {
            list.add(new int[] {position[i], speed[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> stack = new Stack<>();
        for (int[] pair : list) {
            double time = (double) (target - pair[0]) / pair[1];

            stack.push(time);

            while (stack.size() >= 2 && stack.get(stack.size() - 1) <= stack.get(stack.size() - 2)) {
                stack.pop();
            } 
        }

        return stack.size();
    }
}
