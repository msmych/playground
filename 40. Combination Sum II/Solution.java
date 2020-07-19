import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        var candidatesList = new ArrayList<Integer>();
        for (int candidate : candidates) {
            candidatesList.add(candidate);
        }
        var combinations = new ArrayList<List<Integer>>();
        for (var combinationMap : getCombinations(candidatesList, target)) {
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

    private Set<Map<Integer, Integer>> getCombinations(List<Integer> candidates, int target) {
        if (candidates.isEmpty() || target <= 0) {
            return new HashSet<>();
        }
        var combinations = new HashSet<Map<Integer, Integer>>();
        for (var candidate : candidates) {
            if (candidate == target) {
                var combination = new HashMap<Integer, Integer>();
                combination.put(candidate, 1);
                combinations.add(combination);
            }
            var next = new ArrayList<Integer>(candidates);
            next.remove(next.indexOf(candidate));
            for (var nextCombination : getCombinations(next, target - candidate)) {
                nextCombination.put(candidate, nextCombination.getOrDefault(candidate, 0) + 1);
                combinations.add(nextCombination);
            }
        }
        return combinations;
    }

    // java Solution.java "[10,1,2,7,6,1,5]" "8" "[[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]" "[2,5,2,1,2]" "5" "[[1,2,2],[5]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String candidates = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: candidates = %s, target = %s",
                new Solution().combinationSum2(array(candidates), Integer.parseInt(target)), expected, candidates, target));
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
