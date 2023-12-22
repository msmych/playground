package uk.matvey.play.leet1362.java1;

public class Solution {
    public int[] closestDivisors(int num) {
        for (int i = ((int) Math.sqrt(num)) + 1; i > 1; i--) {
            if ((num + 1) % i == 0) {
                return new int[]{i, (num + 1) / i};
            } else if ((num + 2) % i == 0) {
                return new int[]{i, (num + 2) / i};
            }
        }
        return new int[]{1, num + 1};
    }
}
