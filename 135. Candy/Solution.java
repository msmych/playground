import static java.util.Arrays.*;

class Solution {

    public int candy(int[] ratings) {
        var candies = new int[ratings.length];
        var kids = 0;
        while (kids++ < candies.length) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (var i = 0; i < candies.length; i++) {
                if (candies[i] == 0) {
                    if (ratings[i] < min) {
                        min = ratings[i];
                        minIndex = i;
                    }
                }
            }
            candies[minIndex] = 1;
            if (minIndex > 0 && ratings[minIndex] > ratings[minIndex - 1] && candies[minIndex] <= candies[minIndex - 1]) {
                candies[minIndex] = candies[minIndex - 1] + 1;
            }
            if (minIndex < candies.length - 1 && ratings[minIndex] > ratings[minIndex + 1] && candies[minIndex] <= candies[minIndex + 1]) {
                candies[minIndex] = candies[minIndex + 1] + 1;
            }
        }
        return stream(candies).sum();
    }

    // java Solution.java "[1,0,2]" "5" "[1,2,2]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String ratings = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: ratings = %s",
                new Solution().candy(intArr(ratings)), expected, ratings));
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
