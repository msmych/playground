import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

class Solution {
    public String sortString(String s) {

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = s.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(c -> c, summingInt(c -> 1)));
        while (!map.isEmpty()) {
            char last = 'a' - 1;
            while (true) {
                char temp = last;
                Optional<Character> c = map.keySet().stream()
                    .filter(k -> k > temp)
                    .min(naturalOrder());
                if (c.isEmpty()) {
                    break;
                }
                take(c.get(), map);
                sb.append(c.get());
                last = c.get();
            }
            last = 'z' + 1;
            while (true) {
                char temp = last;
                Optional<Character> c = map.keySet().stream()
                    .filter(k -> k < temp)
                    .max(naturalOrder());
                if (c.isEmpty()) {
                    break;
                }
                take(c.get(), map);
                sb.append(c.get());
                last = c.get();
            }
        }
        return sb.toString();
    }

    private void take(char c, Map<Character, Integer> map) {
        if (map.get(c) == 1) {
            map.remove(c);
        } else {
            map.put(c, map.get(c) - 1);
        }
    }

    // java Solution.java "aaaabbbbcccc" "abccbaabccba" "rat" "art" "leetcode" "cdelotee" "ggggggg" "ggggggg" "spo" "ops"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().sortString(s), expected, s));
        }
    }
}
