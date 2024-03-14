package uk.matvey.problems.leet0948;

import java.util.ArrayDeque;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        var deque = new ArrayDeque<Integer>();
        Arrays.stream(tokens).sorted().forEach(deque::offer);
        while (!deque.isEmpty()) {
            if (power >= deque.peek()) {
                power -= deque.pop();
                score++;
            } else if (score > 0 && deque.size() > 1 && power + deque.getLast() >= deque.getFirst()) {
                power += deque.removeLast();
                score--;
            } else {
                break;
            }
        }
        return score;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var tokens = new int[]{100};

        var result = new Solution().bagOfTokensScore(tokens, 50);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case2() {
        var tokens = new int[]{200, 100};

        var result = new Solution().bagOfTokensScore(tokens, 150);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        var tokens = new int[]{100, 200, 300, 400};

        var result = new Solution().bagOfTokensScore(tokens, 200);

        assertThat(result).isEqualTo(2);
    }
}
