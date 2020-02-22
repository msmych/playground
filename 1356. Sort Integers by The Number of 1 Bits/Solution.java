import java.util.Comparator;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

class Solution {
    public int[] sortByBits(int[] arr) {
        return stream(arr)
            .boxed()
            .sorted((a, b) -> {
                int a1 = ones(a);
                int b1 = ones(b);
                return a1 == b1 ? Integer.compare(a, b) : Integer.compare(a1, b1);
            })
            .mapToInt(n -> n)
            .toArray();
    }

    private int ones(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 2) {
            if ((n & i) > 0) {
                count++;
            }
        }
        return count;
    }

    // java Solution.java "[0,1,2,3,4,5,6,7,8]" "[0,1,2,4,8,3,5,6,7]" "[1024,512,256,128,64,32,16,8,4,2,1]" "[1,2,4,8,16,32,64,128,256,512,1024]" "[10000,10000]" "[10000,10000]" "[2,3,5,7,11,13,17,19]" "[2,3,5,17,7,11,13,19]" "[10,100,1000,10000]" "[10,100,10000,1000]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                string(new Solution().sortByBits(array(arr))), expected, arr));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
