class Solution {

    public int countTriplets(int[] arr) {
        var xors = new int[arr.length + 1];
        for (var i = 0; i < arr.length; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        var count = 0;
        for (var i = 0; i < arr.length - 1; i++) {
            for (var j = i + 1; j < arr.length; j++) {
                if ((xors[j + 1] ^ xors[i]) == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }

    // java Solution.java "[2,3,1,6,7]" "4" "[1,1,1,1,1]" "10" "[2,3]" "0" "[1,3,5,7,9]" "3" "[7,11,12,9,5,2,7,17,22]" "8"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().countTriplets(array(arr)), expected, arr));
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
