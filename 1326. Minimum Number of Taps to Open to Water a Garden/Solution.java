class Solution {
    public int minTaps(int n, int[] ranges) {
        return 0;
    }

    // java Solution.java "5" "[3,4,1,1,0,0]" "1" "3" "[0,0,0,0]" "-1" "7" "[1,2,1,0,2,1,0,1]" "3" "8" "[4,0,0,0,0,0,0,0,4]" "2" "8" "[4,0,0,0,4,0,0,0,4]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], ranges = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, ranges = %s",
                new Solution().minTaps(Integer.parseInt(n), array(ranges)), expected, n, ranges));
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
