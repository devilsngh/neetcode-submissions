class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, maxf = 0;

        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxf = Math.max(maxf, map.get(ch));

            while ((r - l + 1) - maxf > k) {
                char temp = s.charAt(l);
                map.put(temp, map.get(temp) - 1);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
