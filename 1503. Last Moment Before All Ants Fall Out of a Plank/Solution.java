class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        return 0;
    }

    // java Solution.java "4" "[4,3]" "[0,1]" "4" "7" "[]" "[0,1,2,3,4,5,6,7]" "7" "7" "[0,1,2,3,4,5,6,7]" "[]" "7" "9" "[5]" "[4]" "5" "6" "[6]" "[0]" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], left = args[i + 1], right = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, left = %s, right = %s",
                new Solution().getLastMoment(Integer.parseInt(n), array(left), array(right)), expected, n, left, right));
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
