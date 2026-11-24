class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> prevMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int find = target - nums[i];
            if (prevMap.containsKey(find)) {
                return new int[] {prevMap.get(find), i};
            }

            prevMap.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }
}
