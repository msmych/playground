package uk.matvey.problems.leet0014;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        var sb = new StringBuilder();
        while (true) {
            if (strs[0].length() <= sb.length()) {
                break;
            }
            var c = strs[0].charAt(sb.length());
            var isCommon = true;
            for (var str : strs) {
                if (str.length() <= sb.length() || str.charAt(sb.length()) != c) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var strs = new String[]{"flower", "flow", "flight"};

        assertThat(new Solution().longestCommonPrefix(strs)).isEqualTo("fl");
    }

    @Test
    void case2() {
        var strs = new String[]{"dog", "racecar", "car"};

        assertThat(new Solution().longestCommonPrefix(strs)).isEqualTo("");
    }
}