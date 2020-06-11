import java.util.*;

class Solution {

    private final Random random = new Random();

    private final int[] sums;

    public Solution(int[] w) {
        sums = new int[w.length];
        sums[0] = w[0];
        for (var i = 1; i < w.length; i++) {
            sums[i] = sums[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        var r = random.nextInt(sums[sums.length - 1]) + 1;
        int left = 0, right = sums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] == r) {
                return mid;
            } else if (sums[mid] < r) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String... args) {
        var solution = new Solution(new int[]{3, 14, 1, 7});
        for (var i = 0; i < 100; i++) {
            System.out.println(solution.pickIndex());
        }
    }
}
