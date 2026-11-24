class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String tempStr = new String(strArr);

            map.putIfAbsent(tempStr, new ArrayList<>());

            map.get(tempStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
