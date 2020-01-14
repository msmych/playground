import java.util.Set;
import java.util.HashSet;

class Solution {

    public int distinctEchoSubstrings(String text) {
        Set<String> echoes = new HashSet<>();
        for (int i = 1; i <= text.length() / 2; i++) {
            for (int j = 0; j + 2 * i <= text.length(); j++) {
                String echo = text.substring(j, j + i);
                if (!echoes.contains(echo) && echo.equals(text.substring(j + i, j + 2 * i))) {
                    echoes.add(echo);
                }
            }
        }
        return echoes.size();
    }

    // java Solution.java abcabcabc 3 leetcodeleetcode 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            Solution solution = new Solution();
            String text = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text = %s",
                solution.distinctEchoSubstrings(text), expected, text));
        }
    }
}
