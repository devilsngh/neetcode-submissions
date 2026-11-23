class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        int n = s.length();
        int m = t.length();
        if (n != m) return false;

        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a']++;
            hash[t.charAt(i) - 'a']--;
        }

        for (int num : hash) {
            if (num != 0) return false;
        }

        return true;
    }
}
