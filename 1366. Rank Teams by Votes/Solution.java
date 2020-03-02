import static java.util.Arrays.stream;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

import java.util.Map;

import java.util.OptionalInt;
import java.util.Set;

class Solution {
    public String rankTeams(String[] votes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            Set<Character> set = votes[0].chars().mapToObj(c -> (char) c).filter(c -> !sb.toString().contains(c.toString()))
                    .collect(toSet());
            for (int j = 0; j < votes[0].length(); j++) {
                int index = j;
                Map<Character, Integer> map = stream(votes).map(vote -> vote.charAt(index)).filter(set::contains)
                        .collect(groupingBy(c -> c, summingInt(c -> 1)));
                OptionalInt max = map.values().stream().mapToInt(v -> v).max();
                if (max.isPresent()) {
                    Set<Character> next = map.entrySet().stream().filter(e -> e.getValue() == max.getAsInt())
                            .map(Map.Entry::getKey).collect(toSet());
                    if (next.size() == 1) {
                        sb.append(next.iterator().next());
                        break;
                    }
                    set = next;
                }
            }
            if (sb.length() == i) {
                sb.append(set.stream().min(naturalOrder()).get());
            }
        }
        return sb.toString();
    }

    // java Solution.java "[ABC,ACB,ABC,ACB,ACB]" "ACB" "[WXYZ,XYZW]" "XWYZ" "[ZMNAGUEDSJYLBOPHRQICWFXTVK]" "ZMNAGUEDSJYLBOPHRQICWFXTVK" "[BCA,CAB,CBA,ABC,ACB,BAC]" "ABC" "[M,M,M,M]" "M"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String votes = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: votes = %s",
                new Solution().rankTeams(array(votes)), expected, votes));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
