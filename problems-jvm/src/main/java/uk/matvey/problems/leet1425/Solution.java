package uk.matvey.problems.leet1425;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{10, 2, -10, 5, 20};

        int result = new Solution().constrainedSubsetSum(nums, 2);

        assertThat(result).isEqualTo(37);
    }

    @Test
    public void case2() {
        var nums = new int[]{-1, -2, -3};

        int result = new Solution().constrainedSubsetSum(nums, 1);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void case3() {
        var nums = new int[]{10, -2, -10, -5, 20};

        int result = new Solution().constrainedSubsetSum(nums, 2);

        assertThat(result).isEqualTo(23);
    }

    @Test
    public void case4() {
        var nums = new int[]{-5266, 4019, 7336, -3681, -5767};

        int result = new Solution().constrainedSubsetSum(nums, 2);

        assertThat(result).isEqualTo(11355);
    }

    @Test
    public void case5() {
        var nums = new int[]{-8269, 3217, -4023, -4138, -683, 6455, -3621, 9242, 4015, -3790};

        int result = new Solution().constrainedSubsetSum(nums, 1);

        assertThat(result).isEqualTo(16091);
    }

    @Test
    public void case6() {
        var nums = new int[]{10, 10, 10, 10, -10, -1, -10, -1, -10, 10, 10, 10, 10};

        int result = new Solution().constrainedSubsetSum(nums, 3);

        assertThat(result).isEqualTo(78);
    }

    @Test
    public void case7() {
        var testCaseReader = new TestCaseReader("leet1425/case7");
        var nums = testCaseReader.parseIntArr("nums.txt");

        int result = new Solution().constrainedSubsetSum(nums, 58823);

        assertThat(result).isEqualTo(250377944);
    }
}
