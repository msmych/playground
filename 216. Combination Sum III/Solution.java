import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return null;
    }

    // java Solution.java "3" "7" "[[1,2,4]]" "3" "9" "[[1,2,6], [1,3,5], [2,3,4]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String k = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: k = %s, n = %s",
                new Solution().combinationSum3(Integer.parseInt(k), Integer.parseInt(n)), expected, k, n));
        }
    }
}
