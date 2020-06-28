class Solution {
    public boolean canArrange(int[] arr, int k) {
        return false;
    }

    // java Solution.java "[1,2,3,4,5,10,6,7,8,9]" "5" "true" "[1,2,3,4,5,6]" "7" "true" "[1,2,3,4,5,6]" "10" "false" "[-10,10]" "2" "true" "[-1,1,-2,2,-3,3,-4,4]" "3" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String arr = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, k = %s",
                new Solution().canArrange(array(arr), Integer.parseInt(k)), expected, arr, k));
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
