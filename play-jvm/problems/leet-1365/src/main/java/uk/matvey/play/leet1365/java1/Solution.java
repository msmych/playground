package uk.matvey.play.leet1365.java1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        Arrays.sort(arr);
        var map = new HashMap<Integer, Integer>();
        map.put(arr[0], 0);
        for (int i = 1, last = arr[0]; i < arr.length; i++) {
            if (arr[i] != last) {
                map.put(arr[i], i);
                last = arr[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
