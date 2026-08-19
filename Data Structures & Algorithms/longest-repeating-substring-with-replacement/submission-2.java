class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        Set<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        int n = s.length();
        for (char ch : set) {
            int count = 0, l = 0;
            if (maxLen == n) return maxLen;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == ch) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == ch) {
                        count--;
                    }
                    l++;
                }
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }
}
