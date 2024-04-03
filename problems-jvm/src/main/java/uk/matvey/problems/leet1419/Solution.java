package uk.matvey.problems.leet1419;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
        var map = new HashMap<Character, Integer>();
        if (!croakOfFrogs.endsWith("k")) {
            return -1;
        }
        int frogs = 0;
        int balance = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c':
                    if (balance == 0) {
                        frogs++;
                    } else {
                        balance--;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'r':
                    if (map.getOrDefault('c', 0) - map.getOrDefault('r', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'o':
                    if (map.getOrDefault('r', 0) - map.getOrDefault('o', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'a':
                    if (map.getOrDefault('o', 0) - map.getOrDefault('a', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    break;
                case 'k':
                    if (map.getOrDefault('a', 0) - map.getOrDefault('k', 0) < 1) {
                        return -1;
                    }
                    map.merge(c, 1, Integer::sum);
                    balance++;
            }
        }
        return frogs;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().minNumberOfFrogs("croakcroak")).isEqualTo(1);
    }

    @Test
    void case2() {
        assertThat(new Solution().minNumberOfFrogs("crcoakroak")).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().minNumberOfFrogs("croakcrook")).isEqualTo(-1);
    }

    @Test
    void case4() {
        assertThat(new Solution().minNumberOfFrogs("croakcroa")).isEqualTo(-1);
    }

    @Test
    void case5() {
        assertThat(new Solution().minNumberOfFrogs("aoocrrackk")).isEqualTo(-1);
    }

    @Test
    void case6() {
        assertThat(new Solution().minNumberOfFrogs("crocakcroraoakk")).isEqualTo(2);
    }
}
