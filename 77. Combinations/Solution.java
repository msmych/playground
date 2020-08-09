import java.util.*;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        var combinations = new ArrayList<List<Integer>>();
        nextCombination(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private void nextCombination(int n, int k, int index, ArrayList<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (var i = index; i <= n; i++) {
            current.add(i);
            nextCombination(n, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

    // java Solution.java "4" "2" "[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, k = %s",
                new Solution().combine(Integer.parseInt(n), Integer.parseInt(k)), expected, n, k));
        }
    }
}
