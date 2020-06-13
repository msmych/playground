class Solution {
    public int[] finalPrices(int[] prices) {
        for (var i = 0; i < prices.length; i++) {
            for (var j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    // java Solution.java "[8,4,6,2,3]" "[4,2,4,2,3]" "[1,2,3,4,5]" "[1,2,3,4,5]" "[10,1,1,6]" "[9,0,1,6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String prices = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: prices = %s",
                string(new Solution().finalPrices(array(prices))), expected, prices));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
