import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    private final Map<List<Integer>, Integer> cache = new HashMap<>();

    public int maxProduct(int[] nums) {
        return nextMax(stream(nums).boxed().collect(toList()));
    }

    private int nextMax(List<Integer> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        if (cache.containsKey(list)) {
            return cache.get(list);
        }
        var nonZeroSublists = splitZeroesTrimOnes(list);
        int max = nonZeroSublists.stream()
                .mapToInt(nzs -> nzs.stream().reduce((n1, n2) -> n1 * n2).orElse(Integer.MIN_VALUE))
                .max()
                .orElse(Integer.MIN_VALUE);
        if (max < 0 && list.stream().anyMatch(n -> n == 0)) {
            max = 0;
        }
        for (var nonZeroSublist : nonZeroSublists) {
            for (var i = 0; i < nonZeroSublist.size(); i++) {
                var left = nonZeroSublist.subList(0, i);
                var leftMax = nextMax(left);
                if (leftMax > max) {
                    max = leftMax;
                }
                var right = nonZeroSublist.subList(i + 1, nonZeroSublist.size());
                var rightMax = nextMax(right);
                if (rightMax > max) {
                    max = rightMax;
                }
            }
        }
        cache.put(list, max);
        return max;
    }

    private List<List<Integer>> splitZeroesTrimOnes(List<Integer> list) {
        var nonZeroSublists = new ArrayList<List<Integer>>();
        var nonZeroSublist = new ArrayList<Integer>();
        for (var num : list) {
            if (num == 0) {
                nonZeroSublists.addAll(trimOnes(nonZeroSublist));
                nonZeroSublist = new ArrayList<>();
            } else {
                nonZeroSublist.add(num);
            }
        }
        nonZeroSublists.addAll(trimOnes(nonZeroSublist));
        return nonZeroSublists;
    }

    private List<List<Integer>> trimOnes(List<Integer> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        if (list.stream().allMatch(n -> abs(n) == 1)) {
            if (list.size() == 1) {
                return List.of(list);
            }
            return List.of(List.of(1), List.of(-1));
        }
        int leadingLength = 0;
        while (leadingLength < list.size()) {
            if (abs(list.get(leadingLength)) == 1) {
                leadingLength++;
            } else {
                break;
            }
        }
        var trainlingLength = 0;
        while (list.size() - 1 - trainlingLength >= 0) {
            if (Math.abs(list.get(list.size() - 1 - trainlingLength)) == 1) {
                trainlingLength++;
            } else {
                break;
            }
        }
        var trimmed = new ArrayList<List<Integer>>();
        trimmed.add(list.subList(leadingLength, list.size() - trainlingLength));
        var leading = leadingLength > 0 ? list.subList(0, leadingLength) : new ArrayList<Integer>();
        var trailing = trainlingLength > 0 ? list.subList(list.size() - trainlingLength, list.size()) : new ArrayList<Integer>();
        if (leading.contains(1) || trailing.contains(1)) {
            trimmed.add(List.of(1));
        }
        if ((leading.contains(-1) || trailing.contains(-1))) {
            var opposite = new ArrayList<>(trimmed.get(0));
            opposite.add(-1);
            trimmed.add(opposite);
        }
        return trimmed;
    }

    // java Solution.java "[2,3,-2,4]" "6" "[-2,0,-1]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().maxProduct(intArr(nums)), expected, nums));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
