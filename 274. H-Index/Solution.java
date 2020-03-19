class Solution {
    public int hIndex(int[] citations) {
        return 0;
    }

    // java Solution.java "[3,0,6,1,5]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String citations = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: citations = %s",
                new Solution().hIndex(array(citations)), expected, citations));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
