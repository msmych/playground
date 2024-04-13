package uk.matvey.problems.leet1447;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        if (n < 2) {
            return List.of();
        }
        var fractions = new ArrayList<String>();
        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                fractions.add(i + "/" + n);
            }
        }
        fractions.addAll(simplifiedFractions(n - 1));
        return fractions;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int x = b;
            b = a % b;
            a = x;
        }
        return a;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var result = new Solution().simplifiedFractions(2);

        assertThat(result).containsExactlyInAnyOrder("1/2");
    }

    @Test
    void case2() {
        var result = new Solution().simplifiedFractions(3);

        assertThat(result).containsExactlyInAnyOrder("1/2", "1/3", "2/3");
    }

    @Test
    void case3() {
        var result = new Solution().simplifiedFractions(4);

        assertThat(result).containsExactlyInAnyOrder("1/2","1/3","1/4","2/3","3/4");
    }

    @Test
    void case4() {
        var result = new Solution().simplifiedFractions(1);

        assertThat(result).containsExactlyInAnyOrder();
    }
}