import java.util.HashSet;

class Solution {

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (var i = 31; i >= 0; i--) {
            mask |= 1 << i;
            var lefts = new HashSet<Integer>();
            for (var num : nums) {
                var left = num & mask;
                lefts.add(left);
            }
            var guess = max | (1 << i);
            for (var left : lefts) {
                var xor = left ^ guess;
                if (lefts.contains(xor)) {
                    max = guess;
                    break;
                }
            }
        }
        return max;
    }

    // java Solution.java "[3, 10, 5, 25, 2, 8]" "28"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMaximumXOR(intArr(nums)), expected, nums));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
