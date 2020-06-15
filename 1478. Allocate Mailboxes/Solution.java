class Solution {
    public int minDistance(int[] houses, int k) {
        return 0;
    }

    // java Solution.java "[1,4,8,10,20]" "3" "5" "[2,3,5,12,18]" "2" "9" "[7,4,6,1]" "1" "8" "[3,6,14,10]" "4" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String houses = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: houses = %s, k = %s",
                new Solution().minDistance(array(houses), Integer.parseInt(k)), expected, houses, k));
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
