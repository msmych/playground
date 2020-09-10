import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Set<Integer>> secretDigits = digitsPositions(secret), guessDigits = digitsPositions(guess);
        int a = 0, b = 0;
        for (var g : guessDigits.entrySet()) {
            var c = g.getKey();
            if (secretDigits.containsKey(c)) {
                var secretPositions = secretDigits.get(c);
                var bullsCows = g.getValue().stream().collect(partitioningBy(secretPositions::contains, counting()));
                a += bullsCows.get(true);
                b += Math.min(bullsCows.get(false), secretPositions.size() - bullsCows.get(true));
            }
        }
        return a + "A" + b + "B";
    }

    private Map<Character, Set<Integer>> digitsPositions(String s) {
        var digitsPositions = new HashMap<Character, Set<Integer>>();
        for (var i = 0; i < s.toCharArray().length; i++) {
            var c = s.charAt(i);
            if (digitsPositions.containsKey(c)) {
                digitsPositions.get(c).add(i);
            } else {
                var positions = new HashSet<Integer>();
                positions.add(i);
                digitsPositions.put(c, positions);
            }
        }
        return digitsPositions;
    }

    // java Solution.java "1807" "7810" "1A3B" "1123" "0111" "1A1B"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String secret = args[i], guess = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: secret = %s, guess = %s",
                new Solution().getHint(secret, guess), expected, secret, guess));
        }
    }
}
