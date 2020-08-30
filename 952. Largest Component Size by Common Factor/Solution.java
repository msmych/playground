class Solution {

    public int largestComponentSize(int[] A) {
        return 0;
    }

    // java Solution.java "[4,6,15,35]" "4" "[20,50,9,63]" "2" "[2,3,6,7,4,12,21,39]" "8"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String A = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s",
                new Solution().largestComponentSize(intArr(A)), expected, A));
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
