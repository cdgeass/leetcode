/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;
        int mid1 = 0, mid2 = 0;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int lmax1 = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int rmin1 = i == m ? Integer.MAX_VALUE : nums1[i];
            int lmax2 = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int rmin2 = j == n ? Integer.MAX_VALUE : nums2[j];

            if (lmax1 <= rmin2) {
                mid1 = Math.max(lmax1, lmax2);
                mid2 = Math.min(rmin1, rmin2);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (mid1 + mid2) / 2.0 : mid1;
    }
}
// @lc code=end

