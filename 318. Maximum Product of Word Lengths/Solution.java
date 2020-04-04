import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparingInt;

class Solution {

    private static class Letters {
        final Set<Character> letters;
        final int count;

        Letters(String word) {
            letters = word.chars().mapToObj(c -> (char) c).collect(toSet());
            count = word.length();
        }
    }

    public int maxProduct(String[] words) {
        var letters = stream(words)
            .sorted(comparingInt(String::length).reversed())
            .map(Letters::new)
            .collect(toList());
        var max = 0;
        for (var i = 0; i < letters.size(); i++) {
            var a = letters.get(i);
            for (var j = i + 1; j < letters.size(); j++) {
                var b = letters.get(j);
                if (a.letters.stream().noneMatch(b.letters::contains)) {
                    if (a.count * b.count > max) {
                        max = a.count * b.count;
                    }
                }
            }
        }
        return max;
    }

    // java Solution.java "[abcw,baz,foo,bar,xtfn,abcdef]" "16" "[a,ab,abc,d,cd,bcd,abcd]" "4" "[a,aa,aaa,aaaa]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String words = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s",
                new Solution().maxProduct(array(words)), expected, words));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
