class Solution {
    public int minFlips(int a, int b, int c) {
        return 0;
    }

    // java Solution.java 2 6 5 3 4 2 7 1 1 2 3 0
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            Solution solution = new Solution();
            String a = args[i], b = args[i + 1], c = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: a = %s, b = %s, c = %s",
                solution.minFlips(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c)), expected, a, b, c));
        }
    }
}
