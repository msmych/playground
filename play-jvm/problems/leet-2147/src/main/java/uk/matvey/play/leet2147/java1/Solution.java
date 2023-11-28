package uk.matvey.play.leet2147.java1;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        if (corridor.indexOf('S') == -1) {
            return 0;
        }
        if (corridor.chars().filter(c -> c == 'S').count() % 2 == 1) {
            return 0;
        }
        long count = 1;
        int seats = 0;
        int plants = 0;
        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                seats++;
                if (seats % 2 == 1) {
                    if (seats > 1) {
                        count *= plants + 1;
                        count %= MOD;
                    }
                }
                plants = 0;
            } else {
                plants++;
            }
        }
        return (int) count % MOD;
    }
}
