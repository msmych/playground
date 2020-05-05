class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        var lastOne = -1;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOne != -1 && i - lastOne - 1 < k) {
                    return false;
                } else {
                    lastOne = i;
                }
            }
        }
        return true;
    }

    // java Solution.java "[1,0,0,0,1,0,0,1]" "2" "true" "[1,0,0,1,0,1]" "2" "false" "[1,1,1,1,1]" "0" "true" "[0,1,0,1]" "1" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                new Solution().kLengthApart(array(nums), Integer.parseInt(k)), expected, nums, k));
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
