import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        return null;
    }

    // java Solution.java "[0,1,2,4,5,7]" "[0->2,4->5,7]" "[0,2,3,4,6,8,9]" "[0,2->4,6,8->9]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().summaryRanges(array(nums)), expected, nums));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
