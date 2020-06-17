class Solution {

    public String convert(String s, int numRows) {
        var numCols = getNumCols(s.length(), numRows);
        var matrix = new String[numCols][numRows];
        var r = 0;
        var c = 0;
        var direction = true;
        while (s.length() > 0) {
            matrix[c][r] = s.substring(0, 1);
            s = s.substring(1);
            if (direction) {
                if (r < numRows - 1) {
                    r++;
                } else {
                    direction = false;
                    if (numRows > 1) {
                        r--;
                    }
                    c++;
                }
            } else {
                if (r > 0) {
                    r--;
                    c++;
                } else {
                    direction = true;
                    if (numRows > 1) {
                        r++;
                    } else {
                        c++;
                    }
                }
            }
        }
        var zigzag = new StringBuilder();
        for (var i = 0; i < numRows; i++) {
            for (var j = 0; j < numCols; j++) {
                String letter = matrix[j][i];
                if (letter != null) {
                    zigzag.append(letter);
                }
            }
        }
        return zigzag.toString();
    }

    private int getNumCols(int length, int numRows) {
        var vLength = 2 * numRows - 2;
        var vWidth = numRows - 1;
        if (vLength == 0 || vWidth == 0) {
            return length;
        }
        var colRows = length / vLength * vWidth;
        var reminder = length % vLength;
        if (reminder < numRows) {
            colRows++;
        } else {
            reminder = reminder - numRows;
            colRows = colRows + reminder + 1;
        }
        return colRows;
    }

    // java Solution.java "PAYPALISHIRING" "3" "PAHNAPLSIIGYIR" "PAYPALISHIRING" "4" "PINALSIGYAHRPI"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], numRows = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, numRows = %s",
                new Solution().convert(s, Integer.parseInt(numRows)), expected, s, numRows));
        }
    }
}
