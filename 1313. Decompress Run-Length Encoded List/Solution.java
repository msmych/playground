import java.util.stream.IntStream;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.partitioningBy;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        Map<Boolean, List<Integer>> split = IntStream.range(0, nums.length)
            .boxed()
            .collect(partitioningBy(i -> i % 2 == 0));
        List<Integer> lens = split.get(true).stream().map(i -> nums[i]).collect(toList());
        List<Integer> vals = split.get(false).stream().map(i -> nums[i]).collect(toList());
        int[] original = new int[lens.stream().mapToInt(n -> n).sum()];
        int k = 0;
        for (int i = 0; i < lens.size(); i++) {
            int n = vals.get(i);
            for (int j = lens.get(i); j > 0; j--) {
                original[k++] = n;
            }
        }
        return original;
    }
    
    // java Solution.java "[1,2,3,4]" "[2,4,4,4]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            Solution solution = new Solution();
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(solution.decompressRLElist(array(nums))), expected, nums));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
