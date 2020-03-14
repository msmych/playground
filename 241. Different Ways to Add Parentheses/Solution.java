import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import static java.util.Collections.emptyList;

class Solution {

    private final Map<String, List<Integer>> cache = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty()) {
            return emptyList();
        }
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = input.indexOf("+"), base = 0; i != -1; base = ++i, i = input.substring(i).indexOf("+")) {
            i += base;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (Integer a : left) {
                for (Integer b : right) {
                    result.add(a + b);
                }
            }
        }
        for (int i = input.indexOf("-"), base = 0; i != -1; base = ++i, i = input.substring(i).indexOf("-")) {
            i += base;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (Integer a : left) {
                for (Integer b : right) {
                    result.add(a - b);
                }
            }
        }
        for (int i = input.indexOf("*"), base = 0; i != -1; base = ++i, i = input.substring(i).indexOf("*")) {
            i += base;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for (Integer a : left) {
                for (Integer b : right) {
                    result.add(a * b);
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        cache.put(input, result);
        return result;
    }

    // java Solution.java "2-1-1" "[0, 2]" "2*3-4*5" "[-34, -14, -10, -10, 10]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String input = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: input = %s",
                new Solution().diffWaysToCompute(input), expected, input));
        }
    }
}
