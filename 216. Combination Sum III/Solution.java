import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    private final Map<Set<Integer>, Boolean> combinations = new HashMap<>();

    private int k;
    private int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        nextCombinations(Set.of());
        return combinations.entrySet().stream()
            .filter(e -> e.getValue())
            .map(Map.Entry::getKey)
            .map(ArrayList::new)
            .collect(toList());
    }
    
    private void nextCombinations(Set<Integer> nums) {
        if (nums.size() > k) {
            return;
        }
        if (nums.size() == k) {
            combinations.put(nums, nums.stream().mapToInt(num -> num).sum() == n);
            return;
        }
        if (combinations.containsKey(nums)) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (nums.contains(i)) {
                continue;
            }
            var next = new HashSet<Integer>(nums);
            next.add(i);
            nextCombinations(next);
        }
        combinations.put(nums, false);
    }

    // java Solution.java "3" "7" "[[1,2,4]]" "3" "9" "[[1,2,6], [1,3,5], [2,3,4]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String k = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: k = %s, n = %s",
                new Solution().combinationSum3(Integer.parseInt(k), Integer.parseInt(n)), expected, k, n));
        }
    }
}
