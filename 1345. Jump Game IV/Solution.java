class Solution {
    public int minJumps(int[] arr) {
        return 0;
    }

    // java Solution.java "[100,-23,-23,404,100,23,23,23,3,404]" "3" "[7]" "0" "[7,6,9,6,9,6,9,7]" "1" "[6,1,9]" "2" "[11,22,7,7,7,7,7,7,7,22,13]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().minJumps(array(arr)), expected, arr));
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
