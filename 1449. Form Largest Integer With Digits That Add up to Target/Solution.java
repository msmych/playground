class Solution {
    public String largestNumber(int[] cost, int target) {
        return "";
    }

    // java Solution.java "[4,3,2,5,6,7,2,5,5]" "9" "7772" "[7,6,5,5,5,6,8,7,8]" "12" "85" "[2,4,6,2,4,6,4,4,4]" "5" "0" "[6,10,15,40,40,40,40,40,40]" "47" "32211"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String cost = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: cost = %s, target = %s",
                new Solution().largestNumber(array(cost), Integer.parseInt(target)), expected, cost, target));
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
