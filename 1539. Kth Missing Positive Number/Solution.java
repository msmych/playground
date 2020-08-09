class Solution {

    public int findKthPositive(int[] arr, int k) {
        if (arr.length == 0) {
            return k;
        }
        var last = 0;
        for (var num : arr) {
            var diff = num - last - 1;
            if (k - diff < 1) {
                break;
            }
            k -= diff;
            last = num;
        }
        return last + k;
    }

    // java Solution.java "[2,3,4,7,11]" "5" "9" "[1,2,3,4]" "2" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String arr = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, k = %s",
                new Solution().findKthPositive(intArr(arr), Integer.parseInt(k)), expected, arr, k));
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
