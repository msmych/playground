import java.util.*;

class Solution {

    public boolean isStrobogrammatic(String num) {
        for (var i = 0; i < num.length() / 2; i++) {
            var complement = num.charAt(num.length() - i - 1);
            switch (num.charAt(i)) {
                case '0':
                    if (complement != '0') {
                        return false;
                    }
                    break;
                case '1':
                    if (complement != '1') {
                        return false;
                    }
                    break;
                case '6':
                    if (complement != '9') {
                        return false;
                    }
                    break;
                case '8':
                    if (complement != '8') {
                        return false;
                    }
                    break;
                case '9':
                    if (complement != '6') {
                        return false;
                    }
                    break;
                default: return false;
            }
        }
        if (num.length() % 2 == 1 && !Set.of('0', '1', '8').contains(num.charAt(num.length() / 2))) {
            return false;
        }
        return true;
    }

    // java Solution.java "69" "true" "88" "true" "962" "false" "1" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().isStrobogrammatic(num), expected, num));
        }
    }
}
