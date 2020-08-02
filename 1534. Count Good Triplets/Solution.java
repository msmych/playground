import static java.lang.Math.*;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        var good = 0;
        for (var i = 0; i < arr.length - 2; i++) {
            for (var j = i + 1; j < arr.length - 1; j++) {
                if (abs(arr[j] - arr[i]) > a) {
                    continue;
                }
                for (var k = j + 1; k < arr.length; k++) {
                    if (abs(arr[k] - arr[j]) <= b && abs(arr[k] - arr[i]) <= c) {
                        good++;
                    }
                }
            }
        }
        return good;
    }

    // java Solution.java "[3,0,1,1,9,7]" "7" "2" "3" "4" "[1,1,2,2,3]" "0" "0" "1" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 5) {
            String arr = args[i], a = args[i + 1], b = args[i + 2], c = args[i + 3], expected = args[i + 4];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, a = %s, b = %s, c = %s",
                new Solution().countGoodTriplets(intArr(arr), Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c)), expected, arr, a, b, c));
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
