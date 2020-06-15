class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        return 0;
    }

    // java Solution.java "[3,2,2,4,3]" "3" "2" "[7,3,4,7]" "7" "2" "[4,3,2,6,2,3,4]" "6" "-1" "[5,5,4,4,5]" "3" "-1" "[3,1,1,1,5,1,2,1]" "3" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String arr = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, target = %s",
                new Solution().minSumOfLengths(array(arr), Integer.parseInt(target)), expected, arr, target));
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
