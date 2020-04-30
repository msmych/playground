class Solution {
    public int[] countBits(int num) {
        var bits = new int[num + 1];
        for (int i = 1, j = 0, base = 1; i <= num; i++, j++) {
            if (j == base) {
                j = 0;
                base *= 2;
            }
            bits[i] = bits[j] + 1; 
        }
        return bits;
    }

    // java Solution.java "2" "[0,1,1]" "5" "[0,1,1,2,1,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                string(new Solution().countBits(Integer.parseInt(num))), expected, num));
        }
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
