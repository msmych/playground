import java.util.*;

class Solution {

    private int numRows;

    public List<List<Integer>> generate(int numRows) {
        this.numRows = numRows;
        return generateNext(List.of(), 0);
    }

    private List<List<Integer>> generateNext(List<Integer> previous, int i) {
        if (i == numRows) {
            return new ArrayList<>();
        }
        var triangle = new ArrayList<List<Integer>>();
        var row = new ArrayList<Integer>();
        for (var j = 0; j <= i; j++) {
            row.add(j == 0 || j == i ? 1 : previous.get(j - 1) + previous.get(j));
        }
        triangle.add(row);
        triangle.addAll(generateNext(row, i + 1));
        return triangle;
    }

    // java Solution.java "5" "[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String numRows = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numRows = %s",
                new Solution().generate(Integer.parseInt(numRows)), expected, numRows));
        }
    }
}
