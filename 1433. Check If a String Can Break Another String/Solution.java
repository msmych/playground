import static java.util.stream.IntStream.range;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        var arr1 = s1.chars().sorted().toArray();
        var arr2 = s2.chars().sorted().toArray();
        return range(0, s1.length()).allMatch(i -> arr1[i] >= arr2[i]) ||
            range(0, s2.length()).allMatch(i -> arr2[i] >= arr1[i]);
    }

    // java Solution.java "abc" "xya" "true" "abe" "acd" "false" "leetcodee" "interview" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s1 = args[i], s2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s1 = %s, s2 = %s",
                new Solution().checkIfCanBreak(s1, s2), expected, s1, s2));
        }
    }
}
