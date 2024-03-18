package uk.matvey.problems.leet1345;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minJumps(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] == arr[arr.length - 1]) {
            return 1;
        }
        if (arr[0] == arr[arr.length - 2]) {
            return 2;
        }
        var map = IntStream.range(0, arr.length).boxed().collect(Collectors.groupingBy(i -> arr[i]));
        var queue = new LinkedList<Integer>();
        queue.offer(0);
        var visited = new HashSet<Integer>();
        int jumps = 0;
        while (!queue.isEmpty()) {
            for (int q = queue.size(); q > 0; q--) {
                Integer i = queue.poll();
                if (i == arr.length - 1) {
                    return jumps;
                }
                visited.add(i);
                if (i > 0 && !visited.contains(i - 1)) {
                    queue.offer(i - 1);
                }
                if (i < arr.length - 1 && !visited.contains(i + 1)) {
                    queue.offer(i + 1);
                }
                int n = arr[i];
                for (Integer next : map.get(n)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            jumps++;
        }
        return jumps;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var arr = new int[]{7};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        var arr = new int[]{7, 6, 9, 6, 9, 6, 9, 7};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var arr = new int[]{6, 1, 9};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case5() {
        var arr = new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13};

        int result = new Solution().minJumps(arr);

        assertThat(result).isEqualTo(3);
    }
}
