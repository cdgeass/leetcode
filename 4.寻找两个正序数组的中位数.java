/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] temp = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (true) {
            if (i < len1 && (j >= len2 || nums1[i] <= nums2[j])) {
                temp[k++] = nums1[i];
                i++;
            } else if (j < len2 && (i >= len1 || nums1[i] >= nums2[j])) {
                temp[k++] = nums2[j];
                j++;
            } else {
                break;
            }
        }
        int middle = temp.length / 2;
        if (temp.length % 2 == 0) {
            return (temp[middle - 1] + temp[middle]) / 2.0;
        } else {
            return temp[middle];
        }
    }
}
// @lc code=end

