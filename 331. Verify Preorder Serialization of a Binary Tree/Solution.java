class Solution {
    public boolean isValidSerialization(String preorder) {
        return false;
    }

    // java Solution.java "9,3,4,\#,\#,1,\#,\#,2,\#,6,\#,\#" "true" "1,\#" "false" "9,\#,\#,1" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String preorder = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: preorder = %s",
                new Solution().isValidSerialization(preorder), expected, preorder));
        }
    }
}
