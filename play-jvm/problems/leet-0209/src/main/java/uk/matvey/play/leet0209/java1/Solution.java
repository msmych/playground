package uk.matvey.play.leet0209.java1;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = 0, sum = 0, left = 0;
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                var l = i - left + 1;
                if (len == 0 || l < len) {
                    len = l;
                }
                sum -= nums[left++];
            }
        }
        return len;
    }
}
