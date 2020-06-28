import static java.lang.Math.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        var closest = Integer.MIN_VALUE;
        for (var i = 0; i < nums.length - 2; i++) {
            for (var j = i + 1; j < nums.length - 1; j++) {
                var sum2 = nums[i] + nums[j];
                for (var k = j + 1; k < nums.length; k++) {
                    var sum3 = sum2 + nums[k];
                    if (abs(target - sum3) < abs((long) target - closest)) {
                        closest = sum3;
                    }
                }
            }
        }
        return closest;
    }

    // java Solution.java "[-1,2,1,-4]" "1" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().threeSumClosest(array(nums), Integer.parseInt(target)), expected, nums, target));
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
