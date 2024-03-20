package uk.matvey.problems.leet2904;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        var ones = new LinkedList<Integer>();
        var minSub = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.offer(i);
                if (ones.size() > k) {
                    ones.poll();
                }
                if (ones.size() == k) {
                    var sub = s.substring(ones.getFirst(), i + 1);
                    if (minSub.isEmpty()) {
                        minSub = sub;
                    } else if (sub.length() < minSub.length()) {
                        minSub = sub;
                    } else if (sub.length() == minSub.length() && sub.compareTo(minSub) < 0) {
                        minSub = sub;
                    }
                }
            }
        }
        return minSub;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().shortestBeautifulSubstring("100011001", 3);

        assertThat(result).isEqualTo("11001");
    }

    @Test
    public void case2() {
        String result = new Solution().shortestBeautifulSubstring("1011", 2);

        assertThat(result).isEqualTo("11");
    }

    @Test
    public void case3() {
        String result = new Solution().shortestBeautifulSubstring("000", 1);

        assertThat(result).isEqualTo("");
    }

    @Test
    public void case4() {
        String result = new Solution().shortestBeautifulSubstring("001110101101101111", 10);

        assertThat(result).isEqualTo("10101101101111");
    }

    @Test
    public void case5() {
        String result = new Solution().shortestBeautifulSubstring("1100100101011001001", 7);

        assertThat(result).isEqualTo("1100100101011");
    }
}
