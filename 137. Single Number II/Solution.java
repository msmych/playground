import static java.util.Arrays.*;

class Solution {

    public int singleNumber(int[] nums) {
        return (int) ((3 * stream(nums).distinct().mapToLong(num -> num).sum() - stream(nums).mapToLong(num -> num).sum()) / 2);
    }

    // java Solution.java "[2,2,3,2]" "3" "[0,1,0,1,0,1,99]" "99"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().singleNumber(intArr(nums)), expected, nums));
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
