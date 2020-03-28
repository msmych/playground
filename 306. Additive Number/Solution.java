class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            for (int j = 1; i + j < num.length(); j++) {
                String s = num.substring(i, i + j);
                if (s.length() > 1 && s.startsWith("0")) {
                    continue;
                }
                Long a = Long.parseLong(s);
                s = num.substring(0, i);
                if (s.length() > 1 && s.startsWith("0")) {
                    continue;
                }
                Long n = Long.parseLong(s) + a;
                for (int k = i + j; k + n.toString().length() <= num.length(); k += a.toString().length()) {
                    s = num.substring(k, k + n.toString().length());
                    if (s.length() > 1 && s.startsWith("0")) {
                        continue;
                    }
                    long b = Long.parseLong(s);
                    if (b != n) {
                        break;
                    }
                    long t = n;
                    n = b + a;
                    a = t;
                    if (k + a.toString().length() == num.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // java Solution.java "112358" "true" "199100199" "true" 123 true 1023 false "111122335588143" true
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().isAdditiveNumber(num), expected, num));
        }
    }
}
