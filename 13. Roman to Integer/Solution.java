class Solution {
    private enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        int value;

        Roman(int value) {
            this.value = value;
        }
    }

    private enum UncommonRoman {
        IV(4),
        IX(9),
        XL(40),
        XC(90),
        CD(400),
        CM(900);

        int value;

        UncommonRoman(int value) {
            this.value = value;
        }
    }

    public int romanToInt(String s) {
        var result = 0;
        var uncommonRomans = UncommonRoman.values();
        for (var i = 0; i < uncommonRomans.length; i++) {
            var uncommonRoman = uncommonRomans[i];
            if (s.contains(uncommonRoman.name())) {
                s = s.replace(uncommonRoman.name(), "");
                result = result + uncommonRoman.value;
            }
        }
        for (var i = 0; i < s.length(); i++) {
            var roman = Roman.valueOf(String.valueOf(s.charAt(i)));
            var value = roman.value;
            result = result + value;
        }

        return result;
    }

    // java Solution.java "III" "3" "IV" "4" "IX" "9" "LVIII" "58" "MCMXCIV" "1994"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().romanToInt(s), expected, s));
        }
    }
}
