import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> singles = new HashSet<>();
        for (int num : nums) {
            if (singles.contains(num)) {
                singles.remove(num);
            } else {
                singles.add(num);
            }
        }
        return singles.stream().mapToInt(n -> n).toArray();
    }

    // java Solution.java "[1,2,1,3,2,5]" "[3,5]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(new Solution().singleNumber(array(nums))), expected, nums));
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
