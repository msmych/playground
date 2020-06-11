class Solution {

    public int change(int amount, int[] coins) {
        var dp = new int[amount + 1];
        dp[0] = 1;
        for (var coin : coins) {
            for (var i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    // java Solution.java "5" "[1, 2, 5]" "4" "3" "[2]" "0" "10" "[10]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String amount = args[i], coins = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: amount = %s, coins = %s",
                new Solution().change(Integer.parseInt(amount), array(coins)), expected, amount, coins));
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
