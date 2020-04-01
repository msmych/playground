import java.util.ArrayList;

import static java.util.stream.IntStream.range;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        var counters = new int[primes.length];
        var table = new ArrayList<Integer>();
        table.add(1);
        while (table.size() < n) {
            var next = range(0, primes.length)
                .map(i -> table.get(counters[i]) * primes[i])
                .min().getAsInt();
            table.add(next);
            range(0, primes.length)
                .filter(i -> table.get(counters[i]) * primes[i] == next)
                .forEach(i -> counters[i]++);
        }
        return table.get(table.size() - 1);
    }

    // java Solution.java "12" "[2,7,13,19]" "32"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], primes = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, primes = %s",
                new Solution().nthSuperUglyNumber(Integer.parseInt(n), array(primes)), expected, n, primes));
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
