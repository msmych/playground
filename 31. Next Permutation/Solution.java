class Solution {

    public void nextPermutation(int[] nums) {
        int sourceIndex = -1, targetIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            int source = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                int target = nums[j];
                if (source > target && (targetIndex == -1 || j > targetIndex)) {
                    sourceIndex = i;
                    targetIndex = j;
                }
            }
        }
        if (sourceIndex != -1) {
            int temp = nums[sourceIndex];
            nums[sourceIndex] = nums[targetIndex];
            nums[targetIndex] = temp;
            sort(nums, targetIndex + 1);
        } else
            sort(nums, 0);
    }

    private void sort(int[] nums, int from) {
        for (int i = from; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex])
                    minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    // java Solution.java "[1,2,3]" "[1,3,2]" "[3,2,1]" "[1,2,3]" "[1,1,5]" "[1,5,1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            var numsArr = array(nums);
            new Solution().nextPermutation(numsArr);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(numsArr), expected, nums));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
