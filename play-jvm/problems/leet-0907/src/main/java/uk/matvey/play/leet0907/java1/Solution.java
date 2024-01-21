package uk.matvey.play.leet0907.java1;

import java.util.Arrays;
import java.util.Stack;

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
