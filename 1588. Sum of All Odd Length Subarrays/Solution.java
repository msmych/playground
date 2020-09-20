class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        var sums = new int[arr.length + 1];
        for (var i = 0; i < arr.length; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
        var sum = 0;
        for (var i = 1; i <= arr.length; i += 2) {
            for (var j = 0; j + i <= arr.length; j++) {
                sum += sums[j + i] - sums[j];
            }
        }
        return sum;
    }

    // java Solution.java "[1,4,2,5,3]" "58" "[1,2]" "3" "[10,11,12]" "66"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().sumOddLengthSubarrays(intArr(arr)), expected, arr));
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
