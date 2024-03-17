package uk.matvey.problems.leet0907;

import java.util.Arrays;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        var lefts = new int[arr.length];
        var rights = new int[arr.length];
        Arrays.fill(lefts, -1);
        Arrays.fill(rights, arr.length);
        var stack = new Stack<Integer>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lefts[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rights[i] = stack.peek();
            }
            stack.push(i);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (i - lefts[i]) * (rights[i] - i) * arr[i];
            sum %= MOD;
        }
        return sum;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{3, 1, 2, 4};

        final var result = new Solution().sumSubarrayMins(arr);

        assertThat(result).isEqualTo(17);
    }

    @Test
    public void case2() {
        var arr = new int[]{11, 81, 94, 43, 3};

        final var result = new Solution().sumSubarrayMins(arr);

        assertThat(result).isEqualTo(444);
    }
}
