package uk.matvey.play.leet0935.java1;

import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        var jumps = Map.of(
            0, Set.of(4, 6),
            1, Set.of(6, 8),
            2, Set.of(7, 9),
            3, Set.of(4, 8),
            4, Set.of(0, 3, 9),
            5, Set.<Integer>of(),
            6, Set.of(0, 1, 7),
            7, Set.of(2, 6),
            8, Set.of(1, 3),
            9, Set.of(2, 4)
        );
        var dp = new int[n][10];
        for (int c = 0; c < 10; c++) {
            dp[0][c] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 10; c++) {
                int count = 0;
                for (var next : jumps.get(c)) {
                    count = (count + dp[i - 1][next]) % MOD;
                }
                dp[i][c] = count;
            }
        }
        return IntStream.range(0, 10).reduce(0, (a, b) -> (a + dp[n - 1][b]) % MOD);
    }
}
