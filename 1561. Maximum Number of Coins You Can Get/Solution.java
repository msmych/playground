import static java.util.Arrays.*;

class Solution {

    public int maxCoins(int[] piles) {
        sort(piles);
        var candies = 0;
        for (int i = piles.length - 2, b = 0; i > b; i -= 2, b++) {
            candies += piles[i];
        }
        return candies;
    }

    // java Solution.java "[2,4,1,2,7,8]" "9" "[2,4,5]" "4" "[9,8,7,6,5,1,2,3,4]" "18"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String piles = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: piles = %s",
                new Solution().maxCoins(intArr(piles)), expected, piles));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
