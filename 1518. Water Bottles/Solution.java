class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = 0, empty = 0;
        while (numBottles > 0) {
            drunk += numBottles;
            var total = numBottles + empty;
            numBottles = total / numExchange;
            empty = total % numExchange;
        }
        return drunk;
    }

    // java Solution.java "9" "3" "13" "15" "4" "19" "5" "5" "6" "2" "3" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String numBottles = args[i], numExchange = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numBottles = %s, numExchange = %s",
                new Solution().numWaterBottles(Integer.parseInt(numBottles), Integer.parseInt(numExchange)), expected, numBottles, numExchange));
        }
    }
}
