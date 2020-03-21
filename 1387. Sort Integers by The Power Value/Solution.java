import static java.util.stream.IntStream.rangeClosed;

class Solution {
    public int getKth(int lo, int hi, int k) {
        return rangeClosed(lo, hi)
            .mapToObj(this::power)
            .sorted((a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            })
            .map(a -> a[0])
            .skip(k - 1)
            .findFirst()
            .get();
    }

    private int[] power(int num) {
        int power = 0;
        for (int n = num; n != 1; power++) { 
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
        }
        return new int[]{num, power};
    }

    // java Solution.java "12" "15" "2" "13" "1" "1" "1" "1" "7" "11" "4" "7" "10" "20" "5" "13" "1" "1000" "777" "570"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String lo = args[i], hi = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: lo = %s, hi = %s, k = %s",
                new Solution().getKth(Integer.parseInt(lo), Integer.parseInt(hi), Integer.parseInt(k)), expected, lo, hi, k));
        }
    }
}
