class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] ans = new int[n + m];
        int pt1 = 0, pt2 = 0;
        int idx = 0;
        while (pt1 < n && pt2 < m) {
            if (nums1[pt1] <= nums2[pt2]) {
                ans[idx++] = nums1[pt1++];
            } else {
                ans[idx++] = nums2[pt2++];
            }
        }

        while (pt1 < n) {
            ans[idx++] = nums1[pt1++];
        }

        while (pt2 < m) {
            ans[idx++] = nums2[pt2++];
        }

        boolean odd = (n + m) % 2 != 0;
        int mid = (n + m) / 2;

        return odd ? ans[mid] : (double) (ans[mid] + ans[mid - 1]) / 2;

    }
}
