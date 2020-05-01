class Solution {
    public boolean isSelfCrossing(int[] x) {
        return false;
    }

    // java Solution.java "[2,1,1,2]" "true" "[1,2,3,4]" "false" "[1,1,1,1]" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String x = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s",
                new Solution().isSelfCrossing(array(x)), expected, x));
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
