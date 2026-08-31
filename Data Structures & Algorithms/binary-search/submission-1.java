class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        return helper(nums, target, l, r);
    }

    private int helper(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            return helper(nums, target, mid + 1, r);
        }

        return helper(nums, target, l, mid - 1);
    }
}
