package uk.matvey.problems.leet2251;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static class Bloom {
        int flower;
        int start;
        int end;

        public Bloom(int flower, int start, int end) {
            this.flower = flower;
            this.start = start;
            this.end = end;
        }
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        var blooms = new ArrayList<Bloom>();
        for (int i = 0; i < flowers.length; i++) {
            blooms.add(new Bloom(i, flowers[i][0], flowers[i][1]));
        }
        var sortedByStart = blooms.stream().sorted(Comparator.comparingInt(b -> b.start)).toList();
        var sortedByEnd = blooms.stream().sorted(Comparator.comparingInt(b -> b.end)).toList();
        var cache = new HashMap<Integer, Integer>();
        var result = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int day = people[i];
            if (cache.containsKey(day)) {
                result[i] = cache.get(day);
                continue;
            }
            int left = 0;
            int right = flowers.length - 2;
            int startFrom = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                var b = sortedByStart.get(mid);
                if (b.start <= day && sortedByStart.get(mid + 1).start > day) {
                    startFrom = mid;
                    break;
                } else if (b.start > day) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (sortedByStart.get(flowers.length - 1).start <= day) {
                startFrom = flowers.length - 1;
            }
            left = 1;
            right = flowers.length - 1;
            int endFrom = flowers.length;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                var b = sortedByEnd.get(mid);
                if (b.end >= day && sortedByEnd.get(mid - 1).end < day) {
                    endFrom = mid;
                    break;
                } else if (b.end < day) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (sortedByEnd.get(0).end >= day) {
                endFrom = 0;
            }
            result[i] = startFrom - endFrom + 1;
            cache.put(day, result[i]);
        }
        return result;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var flowers = new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        var people = new int[]{2, 3, 7, 11};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(1, 2, 2, 2);
    }

    @Test
    public void case2() {
        var flowers = new int[][]{{1, 10}, {3, 3}};
        var people = new int[]{3, 3, 2};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(2, 2, 1);
    }

    @Test
    public void case3() {
        var flowers = new int[][]{{19, 37}, {19, 38}, {19, 35}};
        var people = new int[]{6, 7, 21, 1, 13, 37, 5, 37, 46, 43};

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(0, 0, 3, 0, 0, 2, 0, 2, 0, 0);
    }

    @Test
    public void case4() {
        var testCaseReader = new TestCaseReader("leet2251/case4");
        int[][] flowers = testCaseReader.parseIntArrArr("flowers.txt");
        int[] people = testCaseReader.parseIntArr("people.txt");
        int[] expected = testCaseReader.parseIntArr("expected.txt");

        int[] result = new Solution().fullBloomFlowers(flowers, people);

        assertThat(result).containsExactly(expected);
    }
}
