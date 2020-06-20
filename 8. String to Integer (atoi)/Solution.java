import java.util.regex.*;

class Solution {
    public int myAtoi(String str) {
        var pattern = Pattern.compile("[ ]*[/+/-0-9]?[0-9]+.*");
        var matcher = pattern.matcher(str);
        if (matcher.matches()) {
            var group = matcher.group().trim();
            int sign;
            if (group.charAt(0) == '-') {
                sign = -1;
                group = group.substring(1);
            } else {
                sign = 1;
                if (group.charAt(0) == '+') group = group.substring(1);
            }
            group = group.split("[^0-9]")[0];
            while (group.length() > 0 && group.charAt(0) == '0') {
                group = group.substring(1);
            }
            if (group.length() > 11) {
                group = group.substring(0, 11);
            }
            if (group.length() == 0) {
                group = "0";
            }
            long number = sign * Long.valueOf(group);
            if (number > Integer.MAX_VALUE) {
                number = Integer.MAX_VALUE;
            }
            if (number < Integer.MIN_VALUE) {
                number = Integer.MIN_VALUE;
            }
            return (int) number;
        }
        return 0;
    }

    // java Solution.java "42" "42" "   -42" "-42" "4193 with words" "4193" "words and 987" "0" "-91283472332" "-2147483648"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String str = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: str = %s",
                new Solution().myAtoi(str), expected, str));
        }
    }
}
