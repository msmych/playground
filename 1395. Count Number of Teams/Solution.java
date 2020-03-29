class Solution {
    public int numTeams(int[] rating) {
        int teams = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k] ||
                        rating[i] > rating[j] && rating[j] > rating[k]) {
                        teams++;
                    }
                }
            }
        }
        return teams;
    }

    // java Solution.java "[2,5,3,4,1]" "3" "[2,1,3]" "0" "[1,2,3,4]" "4"
    public static void main(String... args) {
        new Solution().numTeams(array("[2,5,3,4,1]"));
        for (int i = 0; i < args.length; i += 2) {
            String rating = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rating = %s",
                new Solution().numTeams(array(rating)), expected, rating));
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
