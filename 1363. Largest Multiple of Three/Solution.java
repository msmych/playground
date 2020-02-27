class Solution {
    public String largestMultipleOfThree(int[] digits) {
        return "";
    }

    // java Solution.java "[8,1,9]" "981" "[8,6,7,1,0]" "8760" "[1]" "" "[0,0,0,0,0,0]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String digits = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: digits = %s",
                new Solution().largestMultipleOfThree(array(digits)), expected, digits));
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
