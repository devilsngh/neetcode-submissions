class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String tempStr = new String(charArr);

            map.putIfAbsent(tempStr, new ArrayList<>());
            map.get(tempStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
