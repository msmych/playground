package uk.matvey.play.leet1793.java1;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int rightScore = maxScore(nums, k);
        for (int i = 0; i < nums.length / 2; i++) {
            int num = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = num;
        }

        int leftScore = maxScore(nums, nums.length - k - 1);
        return Math.max(rightScore, leftScore);
    }

    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        var left = new int[k];
        int min = 1_000_000;
        for (int i = k - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            left[i] = min;
        }

        var right = new int[n - k];
        min = 1_000_000;
        for (int i = k; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            right[i - k] = min;
        }

        int maxScore = 0;
        for (int j = 0; j < right.length; j++) {
            min = right[j];
            int i = binarySearch(left, min);
            int score = min * ((k + j) - i + 1);
            if (score > maxScore) {
                maxScore = score;
            }
        }

        return maxScore;
    }

    public int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
