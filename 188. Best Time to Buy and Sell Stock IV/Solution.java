class Solution {
    public int maxProfit(int k, int[] prices) {
        return 0;
    }

    // java Solution.java "2" "[2,4,1]" "2" "2" "[3,2,6,5,0,3]" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String k = args[i], prices = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: k = %s, prices = %s",
                new Solution().maxProfit(Integer.parseInt(k), array(prices)), expected, k, prices));
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
