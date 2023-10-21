package uk.matvey.play.leet1425.java1;

import java.util.PriorityQueue;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        var heap = new PriorityQueue<int[]>((a1, a2) -> a2[0] - a1[0]);
        heap.offer(new int[]{nums[0], 0});
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (i - heap.peek()[1] > k) {
                heap.poll();
            }
            int curr = Math.max(0, heap.peek()[0]) + nums[i];
            if (curr > maxSum) {
                maxSum = curr;
            }
            heap.offer(new int[]{curr, i});

        }
        return maxSum;
    }
}
