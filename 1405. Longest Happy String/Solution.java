import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        var map = new HashMap<Character, Integer>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);
        return nextDiverse(map, '0');
    }

    private String nextDiverse(Map<Character, Integer> map, char last) {
        if (map.values().stream().allMatch(v -> v == 0)) {
            return "";
        }
        var max = map.entrySet().stream()
            .collect(maxBy(comparingInt(Map.Entry::getValue))).get();
        if (max.getKey() == last) {
            if (map.entrySet().stream()
                .filter(e -> e.getKey() != max.getKey())
                .allMatch(e -> e.getValue() == 0)) {
                return "";
            }
            var mid = map.entrySet().stream()
                .filter(e -> e.getKey() != max.getKey())
                .collect(maxBy(comparingInt(Map.Entry::getValue)))
                .map(Map.Entry::getKey).get();
            map.merge(mid, -1, Integer::sum);
            return mid + nextDiverse(map, mid);
        } else {
            if (max.getValue() > 1) {
                map.merge(max.getKey(), -2, Integer::sum);
                return max.getKey() + "" + max.getKey() + nextDiverse(map, max.getKey());
            } else {
                map.merge(max.getKey(), -1, Integer::sum);
                return max.getKey() + nextDiverse(map, max.getKey());
            }
        }
    }

    // java Solution.java "1" "1" "7" "ccaccbcc" "2" "2" "1" "aabbc" "7" "1" "0" "aabaa"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String a = args[i], b = args[i + 1], c = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: a = %s, b = %s, c = %s",
                new Solution().longestDiverseString(Integer.parseInt(a), Integer.parseInt(b), Integer.parseInt(c)), expected, a, b, c));
        }
    }
}
