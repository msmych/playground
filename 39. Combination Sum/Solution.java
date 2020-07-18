import java.util.*;

class Solution {

    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        var combinations = new ArrayList<List<Integer>>();
        for (var combinationMap : getCombinations(target)) {
            var combination = new ArrayList<Integer>();
            for (var item : combinationMap.entrySet()) {
                for (var i = 0; i < item.getValue(); i++) {
                    combination.add(item.getKey());
                }
            }
            combinations.add(combination);
        }
        return combinations;
    }

    private Set<Map<Integer, Integer>> getCombinations(int target) {
        var combinations = new HashSet<Map<Integer, Integer>>();
        if (target <= 0) {
            return combinations;
        }
        for (var candidate : candidates) {
            if (candidate == target) {
                var combination = new HashMap<Integer, Integer>();
                combination.put(candidate, 1);
                combinations.add(combination);
            }
            for (var combination : getCombinations(target - candidate)) {
                combination.put(candidate, combination.getOrDefault(candidate, 0) + 1);
                combinations.add(combination);
            }
        }
        return combinations;
    }

    // java Solution.java "[2,3,6,7]" "7" "[[7],[2,2,3]]" "[2,3,5]" "8" "[[2,2,2,2],[2,3,3],[3,5]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String candidates = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: candidates = %s, target = %s",
                new Solution().combinationSum(array(candidates), Integer.parseInt(target)), expected, candidates, target));
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
