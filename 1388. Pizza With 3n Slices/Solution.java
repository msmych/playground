class Solution {
    public int maxSizeSlices(int[] slices) {
        return 0;
    }

    // java Solution.java "[1,2,3,4,5,6]" "10" "[8,9,8,6,1,1]" "16" "[4,1,2,5,8,3,1,9,7]" "21" "[3,1,2]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String slices = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: slices = %s",
                new Solution().maxSizeSlices(array(slices)), expected, slices));
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
