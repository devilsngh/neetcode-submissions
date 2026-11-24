class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numInd = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            numInd.put(nums[i], i);
        }  

        for (int i = 0; i < n; i++) {
            int find = target - nums[i];
            if (numInd.containsKey(find) && i != numInd.get(find)) {
                return new int[] {i, numInd.get(find)};
            }
        }

        return new int[] {-1, -1};
    }
}
