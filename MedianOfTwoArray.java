// Median of Two Sorted Arrays (https://leetcode.com/problems/median-of-two-sorted-arrays)

// Time Complexity: O(log n) where n is shortest array
// Space Complexity: O(n) 
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

public class MedianOfTwoArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // null
        if (nums1.length == 0 && nums2.length == 0)
            return 0.0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0;
        int high = n1;
        while (low <= high) {
            int px = low + (high - low) / 2;
            int py = (n1 + n2) / 2 - px;
            double l1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            double l2 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            double r1 = px == n1 ? Integer.MAX_VALUE : nums2[px];
            double r2 = py == n2 ? Integer.MAX_VALUE : nums2[py];
            if (l1 <= r2 && l2 <= r1) {
                // valid case
                if ((n1 + n2) % 2 == 0) {
                    return (Math.min(r1, r2) + Math.max(l1, l2)) / 2;
                } else { // Odd partition
                    return Math.min(r1, r2);
                }
            } else if (l2 > r1) { // Odd partition
                low = px + 1;
            } else {
                high = px - 1;
            }
        }
        return 1.22;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 15 };
        int[] nums2 = { 2, 5, 14 };
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 5.0
    }
}
