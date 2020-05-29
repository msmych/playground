import java.util.*;

import static java.lang.Math.*;
import static java.util.stream.IntStream.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) {
            return List.of();
        }
        var queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));
        range(0, min(nums1.length, k))
            .forEach(i -> queue.offer(new int[]{nums1[i], nums2[0], 0}));
        var pairs = new ArrayList<List<Integer>>();
        for (; k > 0 && !queue.isEmpty(); k--) {
            var pair = queue.poll();
            pairs.add(List.of(pair[0], pair[1]));
            if (pair[2] == nums2.length - 1) {
                continue;
            }
            queue.offer(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1});
        }
        return pairs;
    }

    // java Solution.java "[1,7,11]" "[2,4,6]" "3" "[[1,2],[1,4],[1,6]]" "[1,1,2]" "[1,2,3]" 2 "[1,1],[1,1]" "[1,2]" "[3]" 3 "[1,3],[2,3]" "[]" "[]" 5 "[]" "[1,1,2]" "[1,2,3]" 10 "[[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]" "[1,2,4]" "[-1,1,2]" 100 "[[1,-1],[2,-1],[1,1],[4,-1],[2,1],[1,2],[2,2],[4,1],[4,2]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String nums1 = args[i], nums2 = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums1 = %s, nums2 = %s, k = %s",
                new Solution().kSmallestPairs(array(nums1), array(nums2), Integer.parseInt(k)), expected, nums1, nums2, k));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
