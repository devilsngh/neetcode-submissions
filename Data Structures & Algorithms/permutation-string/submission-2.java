class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int size1 = map1.size();

        for (int i = 0; i < n2; i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            int size2 = 0;
            for (int j = i; j < n2; j++) {
                char ch = s2.charAt(j);

                map2.put(ch, map2.getOrDefault(ch, 0) + 1);

                if (map1.getOrDefault(ch, 0) < map2.get(ch)) break;
                
                if (map1.getOrDefault(ch, 0) == map2.get(ch)) size2++;

                if (size1 == size2) return true;
            }
        }

        return false;
    }
}
