import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return null;
    }

    // java Solution.java "[3,2,3]" "[3]" "[1,1,1,3,3,2,2,2]" "[1,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().majorityElement(array(nums)), expected, nums));
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
