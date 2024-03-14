package uk.matvey.problems.leet2709;

import java.util.HashSet;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        var set = new HashSet<Integer>();
        int max = 1;
        for (int x : nums) {
            set.add(x);
            if (x > max) {
                max = x;
            }
        }
        if (set.contains(1)) {
            return false;
        }

        var sieve = new int[max + 1];
        for (int d = 2; d <= max; d++) {
            if (sieve[d] == 0) {
                for (int v = d; v <= max; v += d) {
                    sieve[v] = d;
                }
            }
        }

        var union = new Dsu(2 * max + 1);
        for (int num : nums) {
            int i = num;
            while (i > 1) {
                int p = sieve[i];
                int r = p + max;
                if (union.find(r) != union.find(num)) {
                    union.merge(r, num);
                }
                while (i % p == 0) {
                    i /= p;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= max; i++) {
            if (set.contains(i) && union.find(i) == i) {
                count++;
            }
        }
        return count == 1;
    }

    private static class Dsu {

        private final int[] dsu;
        private final int[] size;

        Dsu(int n) {
            dsu = new int[n + 1];
            size = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                dsu[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (dsu[x] == x) {
                return x;
            }
            var a = dsu[x];
            dsu[x] = find(dsu[x]);
            return a;
        }

        void merge(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a == b) {
                return;
            }
            if (size[a] > size[b]) {
                int t = a;
                a = b;
                b = t;
            }
            dsu[a] = b;
            size[b] += size[a];
        }
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{2, 3, 6};

        var result = new Solution().canTraverseAllPairs(nums);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        var nums = new int[]{3, 9, 5};

        var result = new Solution().canTraverseAllPairs(nums);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        var nums = new int[]{4, 3, 12, 8};

        var result = new Solution().canTraverseAllPairs(nums);

        assertThat(result).isTrue();
    }
}
