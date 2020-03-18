import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        var table = new ArrayList<Integer>();
        table.add(1);
        while (table.size() < n) {
            int next = IntStream.of(table.get(i2) * 2, table.get(i3) * 3, table.get(i5) * 5)
                .min()
                .getAsInt();
            table.add(next);
            if (table.get(i2) * 2 == next) {
                i2++;
            }
            if (table.get(i3) * 3 == next) {
                i3++;
            }
            if (table.get(i5) * 5 == next) {
                i5++;
            }
        }
        return table.get(table.size() - 1);
    }

    // java Solution.java "10" "12" 100 1536
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().nthUglyNumber(Integer.parseInt(n)), expected, n));
        }
    }
}
