import java.util.Map;
import java.util.HashMap;

import static java.util.Arrays.stream;

class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int sumFourDivisors(int[] nums) {
        return stream(nums)
            .map(this::sum4)
            .sum();
    }

    private int sum4(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int div2 = 0;
        int div3 = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                if (div2 == 0) {
                    div2 = i;
                } else if (div3 == 0) {
                    div3 = i;
                } else {
                    cache.put(n, 0);
                    return 0;
                }
            }
        }
        if (div3 > 0) {
            cache.put(n, 1 + div2 + div3 + n);
            return 1 + div2 + div3 + n;
        } else {
            cache.put(n, 0);
            return 0;
        }
    } 


    // java Solution.java "[21,4,7]" "32"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().sumFourDivisors(array(nums)), expected, nums));
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
