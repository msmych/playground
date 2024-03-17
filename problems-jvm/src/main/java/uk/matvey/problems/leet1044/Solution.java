package uk.matvey.problems.leet1044;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private String s;

    public String longestDupSubstring(String S) {
        this.s = S;
        int left = 1, right = S.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            var dup = dupStringOfLength(mid);
            if (dup.isPresent()) {
                if (mid == S.length() - 1 || dupStringOfLength(mid + 1).isEmpty()) {
                    return dup.get();
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return dupStringOfLength(left).orElse("");
    }

    private Optional<String> dupStringOfLength(int len) {
        var map = new HashMap<Long, Set<Integer>>();
        long base = 256;
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (hash * base + s.charAt(i)) % Integer.MAX_VALUE;
        }
        long m = 1;
        for (int i = 1; i < len; i++) {
            m = (m * base) % Integer.MAX_VALUE;
        }
        var collisions = new HashSet<Integer>();
        collisions.add(0);
        map.put(hash, collisions);
        for (int i = 0, j = len; j < s.length(); ) {
            hash = ((hash + Integer.MAX_VALUE - m * s.charAt(i++) % Integer.MAX_VALUE) * base + s.charAt(j++)) % Integer.MAX_VALUE;
            if (map.containsKey(hash)) {
                for (var collision : map.get(hash)) {
                    if (s.substring(i, j).equals(s.substring(collision, collision + len))) {
                        return Optional.of(s.substring(i, j));
                    }
                }
            }
            map.putIfAbsent(hash, new HashSet<>());
            map.get(hash).add(i);
        }
        return Optional.empty();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().longestDupSubstring("banana");

        assertThat(result).isEqualTo("ana");
    }

    @Test
    public void case2() {
        String result = new Solution().longestDupSubstring("abcd");

        assertThat(result).isEqualTo("");
    }
}
