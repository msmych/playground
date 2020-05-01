import static java.util.Arrays.stream;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        var sum = stream(cardPoints).sum();
        var leftSum = stream(cardPoints, 0, cardPoints.length - k).sum();
        var max = sum - leftSum;
        for (var i = 0; i < k; i++) {
            leftSum = leftSum - cardPoints[i] + cardPoints[i + (cardPoints.length - k)];
            if (sum - leftSum > max) {
                max = sum - leftSum;
            }
        }
        return max;
    }

    // java Solution.java "[1,2,3,4,5,6,1]" "3" "12" "[2,2,2]" "2" "4" "[9,7,7,9,7,7,9]" "7" "55" "[1,1000,1]" "1" "1" "[1,79,80,1,1,1,200,1]" "3" "202"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String cardPoints = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: cardPoints = %s, k = %s",
                new Solution().maxScore(array(cardPoints), Integer.parseInt(k)), expected, cardPoints, k));
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
