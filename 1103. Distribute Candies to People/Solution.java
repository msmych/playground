class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        var distribution = new int[num_people];
        int c = 1, i = 0;
        while (candies >= c) {
            for (i = 0; i < num_people && candies >= c; i++) {
                distribution[i] += c;
                candies -= c++;
            }
        }
        distribution[i % num_people] += candies;
        return distribution;
    }

    // java Solution.java "7" "4" "[1,2,3,1]" "10" "3" "[5,2,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String candies = args[i], num_people = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: candies = %s, num_people = %s",
                string(new Solution().distributeCandies(Integer.parseInt(candies), Integer.parseInt(num_people))), expected, candies, num_people));
        }
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
