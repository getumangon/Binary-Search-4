// Intersection of Two Arrays II (https://leetcode.com/problems/intersection-of-two-arrays-ii/)

// Time Complexity: O(m*n)
// Space Complexity: O(m or n) // whichever is larger
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: Took reference from lecture

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class intersectionOfTwoArray {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> li = new ArrayList<>();

        for (int num : nums2) {
            if (map.containsKey(num)) {
                li.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }

        int[] res = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            res[i] = li.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        System.out.println(Arrays.toString(intersect(nums1, nums2))); // output: [2, 2]
    }
}