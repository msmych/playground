import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.IntStream.range;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
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
        Map<Integer, List<Integer>> map = range(0, arr.length).boxed().collect(groupingBy(i -> arr[i]));
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> visited = new HashSet<>();
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

    // java Solution.java "[100,-23,-23,404,100,23,23,23,3,404]" "3" "[7]" "0" "[7,6,9,6,9,6,9,7]" "1" "[6,1,9]" "2" "[11,22,7,7,7,7,7,7,7,22,13]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().minJumps(array(arr)), expected, arr));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
