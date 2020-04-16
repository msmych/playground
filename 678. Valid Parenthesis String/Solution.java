class Solution {
    public boolean checkValidString(String s) {
        return isValid(s, 0);
    }

    private boolean isValid(String s, int count) {
        if (count < 0) {
            return false;
        }
        if (s.isEmpty()) {
            return count == 0;
        }
        var next = s.substring(1);
        switch (s.charAt(0)) {
            case '(':
                return isValid(next, count + 1);
            case ')':
                if (count == 0) {
                    return false;
                }
                return isValid(next, count - 1);
            case '*':
                return isValid(s.substring(1), count - 1) ||
                    isValid(next, count) ||
                    isValid(next, count + 1);
        }
        return false;
    }

    // java Solution.java "()" "true" "(*)" "true" "(*))" "true" "******" true "(*)))" false
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().checkValidString(s), expected, s));
        }
    }
}
