class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (Integer.toString(i).contains("0") || Integer.toString(n - i).contains("0")) {
                continue;
            }
            return new int[]{i, n - i};
        }
        throw new IllegalArgumentException();
    }

    // java Solution.java 
    public static void main(String... args) {
        for (int i = 2; i <= 10000; i++) {
            Solution solution = new Solution();
            int[] output = solution.getNoZeroIntegers(i);
            if (Integer.toString(output[0]).contains("0") || Integer.toString(output[1]).contains("0")) {
                System.out.println(String.format("Input: %d | Output: %s", i, string(output)));
            }
        }
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
