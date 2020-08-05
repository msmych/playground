import java.util.regex.*;

class Solution {

    public boolean isNumber(String s) {
        return Pattern.matches("[ ]*[\\+\\-]?(([0-9]+(\\.[0-9]*)?)|(\\.[0-9]+))(e[\\+\\-]?[0-9]+)?[ ]*", s);
    }

    // java Solution.java "0" "true" " 0.1 " "true" "abc" "false" "1 a" "false" "2e10" "true" " -90e3   " "true" " 1e" "false" "e3" "false" " 6e-1" "true" " 99e2.5 " "false" "53.5e93" "true" " --6 " "false" "-+3" "false" "95a54e53" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().isNumber(s), expected, s));
        }
    }
}
