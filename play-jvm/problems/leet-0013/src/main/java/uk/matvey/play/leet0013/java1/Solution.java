package uk.matvey.play.leet0013.java1;

public class Solution {
    private enum Roman {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000);

        final int value;

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

        final int value;

        UncommonRoman(int value) {
            this.value = value;
        }
    }

    public int romanToInt(String s) {
        var result = 0;
        var uncommonRomans = UncommonRoman.values();
        for (var uncommonRoman : uncommonRomans) {
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
}
