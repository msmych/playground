import java.util.*;

class Solution {

    private final Set<Integer> visited = new HashSet<>();

    private int size = 1;

    public List<Integer> grayCode(int n) {
        for (; n > 0; n--) {
            size *= 2;
        }
        return next(new ArrayList<>(), 0);
    }

    public List<Integer> next(List<Integer> list, int a) {
        if (visited.contains(a)) {
            return new ArrayList<>();
        }
        list.add(a);
        visited.add(a);
        if (list.size() == size) {
            return list;
        }
        for (var bit = 1; bit <= size; bit *= 2) {
            var next = a;
            if ((next & bit) > 0) {
                next -= bit;
            } else {
                next += bit;
            }
            var nextList = next(list, next);
            if (!nextList.isEmpty()) {
                return nextList;
            }
        }
        return new ArrayList<>();
    }

    // java Solution.java "2" "[0,1,3,2]" "0" "[0]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().grayCode(Integer.parseInt(n)), expected, n));
        }
    }
}
