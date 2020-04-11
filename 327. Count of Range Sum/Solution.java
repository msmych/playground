class Solution {

    private int lower;
    private int upper;
    private long[] sums;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        sums = new long[nums.length + 1];
        for (var i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeSort(0, sums.length);
    }

    private int mergeSort(int start, int end) {
        if (end - start <= 1) {
            return 0;
        }
        var mid = start + (end - start) / 2;
        var count = mergeSort(start, mid) + mergeSort(mid, end);
        var arr = new long[end - start];
        var t = mid;
        for (int i = start, j = mid, k = mid, r = 0; i < mid; i++, r++) {
            while (k < end && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j++;
            }
            while (t < end && sums[t] < sums[i]) {
                arr[r++] = sums[t++];
            }
            arr[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(arr, 0, sums, start, t - start);
        return count;
    }

    // java Solution.java "[-2,5,-1]" "-2" "2" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String nums = args[i], lower = args[i + 1], upper = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, lower = %s, upper = %s",
                new Solution().countRangeSum(array(nums), Integer.parseInt(lower), Integer.parseInt(upper)), expected, nums, lower, upper));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
