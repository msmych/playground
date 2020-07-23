import java.util.*;

class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();
    private int[] nums;

    public int jump(int[] nums) {
        this.nums = nums;
        return minJumps(0, 0);
    }

    private int minJumps(int from, int jumps) {
        if (from >= nums.length - 1) {
            return jumps;
        }
        var val = nums[from];
        if (from + val >= nums.length - 1) {
            return jumps + 1;
        }
        if (cache.containsKey(from)) {
            var nextJumps = cache.get(from);
            return Integer.MAX_VALUE - nextJumps > jumps ? jumps + nextJumps : Integer.MAX_VALUE;
        }
        var minNextJumps = Integer.MAX_VALUE;
        for (; val > 0; val--) {
            var nextJumps = minJumps(from + val, jumps + 1);
            if (nextJumps < Integer.MAX_VALUE) {
                nextJumps -= jumps;
            }
            if (nextJumps < minNextJumps) {
                minNextJumps = nextJumps;
            }
        }
        cache.put(from, minNextJumps);
        return Integer.MAX_VALUE - minNextJumps > jumps ? jumps + minNextJumps : Integer.MAX_VALUE;
    }

    // java Solution.java "[2,3,1,1,4]" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().jump(array(nums)), expected, nums));
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
