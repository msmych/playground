package uk.matvey.problems.leet1370;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String sortString(String s) {
        var sb = new StringBuilder();
        var map = s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
        while (!map.isEmpty()) {
            char last = 'a' - 1;
            while (true) {
                char temp = last;
                var c = map.keySet().stream()
                    .filter(k -> k > temp)
                    .min(Comparator.naturalOrder());
                if (c.isEmpty()) {
                    break;
                }
                take(c.get(), map);
                sb.append(c.get());
                last = c.get();
            }
            last = 'z' + 1;
            while (true) {
                char temp = last;
                var c = map.keySet().stream()
                    .filter(k -> k < temp)
                    .max(Comparator.naturalOrder());
                if (c.isEmpty()) {
                    break;
                }
                take(c.get(), map);
                sb.append(c.get());
                last = c.get();
            }
        }
        return sb.toString();
    }

    private void take(char c, Map<Character, Integer> map) {
        if (map.get(c) == 1) {
            map.remove(c);
        } else {
            map.merge(c, -1, Integer::sum);
        }
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().sortString("aaaabbbbcccc");

        assertThat(result).isEqualTo("abccbaabccba");
    }

    @Test
    public void case2() {
        String result = new Solution().sortString("rat");

        assertThat(result).isEqualTo("art");
    }

    @Test
    public void case3() {
        String result = new Solution().sortString("leetcode");

        assertThat(result).isEqualTo("cdelotee");
    }

    @Test
    public void case4() {
        String result = new Solution().sortString("ggggggg");

        assertThat(result).isEqualTo("ggggggg");
    }

    @Test
    public void case5() {
        String result = new Solution().sortString("spo");

        assertThat(result).isEqualTo("ops");
    }
}
