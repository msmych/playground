import static java.util.stream.IntStream.*;

class Solution {

    private static final int base = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }
        return powerMod(superPow(a, range(0, b.length - 1).map(i -> b[i]).toArray()), 10) * 
            powerMod(a, b[b.length - 1]) % base;
    }

    private int powerMod(int a, int b) {
        a %= base;
        var mod = 1;
        for (var i = 0; i < b; i++) {
            mod *= a;
            mod %= base;
        }
        return mod;
    }

    // java Solution.java "2" "[3]" "8" "2" "[1, 0]" "1024"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String a = args[i], b = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: a = %s, b = %s",
                new Solution().superPow(Integer.parseInt(a), array(b)), expected, a, b));
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
