class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int i = 0, j = n - 1;
        while (i < j) {
            int sum = arr[i][0] + arr[j][0];
            if (sum == target) return new int[] {Math.min(arr[i][1], arr[j][1]), Math.max(arr[i][1], arr[j][1])};
            else if (sum > target) j--;
            else i++;
        }
        
        return new int[] {-1, -1};
    }
}
