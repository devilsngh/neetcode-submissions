class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        int maxLen = 0;
        for (char ch : set) {
            int l = 0, count = 0;
            for (int r = 0; r < s.length(); r++) {
                char currChar = s.charAt(r);
                if (ch == currChar) count++;

                while ((r - l + 1 - count) > k) {
                    if (ch == s.charAt(l)) {
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
