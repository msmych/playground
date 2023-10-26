package uk.matvey.play.leet0823.java1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.toMap(i -> i, i -> 1L));
        int mod = 1_000_000_007;
        for (int n : arr) {
            for (int f : arr) {
                if (f == n) {
                    break;
                }
                if (n % f == 0 && map.containsKey(n / f)) {
                    map.merge(n, map.get(f) * map.get(n / f) % mod, (a, b) -> (a + b) % mod);
                }
            }
        }
        return map.values().stream().mapToLong(i -> i).mapToInt(i -> (int) i).reduce(0, (a, b) -> (a + b) % mod);
    }
}
