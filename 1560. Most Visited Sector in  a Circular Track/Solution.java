import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public List<Integer> mostVisited(int n, int[] rounds) {
        var visited = new HashMap<Integer, Integer>();
        for (var i = 0; i < rounds.length - 1; i++) {
            for (var j = rounds[i] == 0 ? n - 1 : rounds[i] - 1; j + 1 != rounds[i + 1]; j = (j + 1) % n) {
                visited.merge(j + 1, 1, Integer::sum);
            }
        }
        visited.merge(rounds[rounds.length - 1], 1, Integer::sum);
        var max = visited.values().stream().mapToInt(i -> i).max().getAsInt();
        return visited.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey).sorted().collect(toList());
    }

    // java Solution.java "4" "[1,3,1,2]" "[1,2]" "2" "[2,1,2,1,2,1,2,1,2]" "[2]" "7" "[1,3,5,7]" "[1,2,3,4,5,6,7]" 17 "[16,8]" "[1,2,3,4,5,6,7,8,16,17]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], rounds = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, rounds = %s",
                new Solution().mostVisited(Integer.parseInt(n), intArr(rounds)), expected, n, rounds));
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
