class Solution {
    public int leastInterval(char[] tasks, int n) {
        int counter[] = new int[26];
        for (char task : tasks) {
            counter[task - 'A']++;
        }

        Arrays.sort(counter);

        int maxf = counter[25];
        int idle = (maxf - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxf - 1, counter[i]);
        }

        return Math.max(0, idle) + tasks.length;
    }
}
