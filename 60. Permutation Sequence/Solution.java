class Solution {

    public String getPermutation(int n, int k) {
        var nums = new int[n];
        for (var i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (var i = 0; i < k - 1; i++) {
            nextPermutation(nums);
        }
        var sb = new StringBuilder();
        for (var i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void nextPermutation(int[] nums) {
        int sourceIndex = -1, targetIndex = -1;
        for (var i = nums.length - 1; i > 0; i--) {
            var source = nums[i];
            for (var j = i - 1; j >= 0; j--) {
                var target = nums[j];
                if (source > target && (targetIndex == -1 || j > targetIndex)) {
                    sourceIndex = i;
                    targetIndex = j;
                }
            }
        }
        if (sourceIndex != -1) {
            var temp = nums[sourceIndex];
            nums[sourceIndex] = nums[targetIndex];
            nums[targetIndex] = temp;
            sort(nums, targetIndex + 1);
        } else {
            sort(nums, 0);
        }
    }

    private void sort(int[] nums, int from) {
        for (var i = from; i < nums.length - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            var temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    // java Solution.java "3" "3" "213" "4" "9" "2314"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, k = %s",
                new Solution().getPermutation(Integer.parseInt(n), Integer.parseInt(k)), expected, n, k));
        }
    }
}
