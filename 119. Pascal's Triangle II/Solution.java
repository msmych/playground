import java.util.*;

class Solution {

    public List<Integer> getRow(int rowIndex) {
        return nextRow(new ArrayList<>(), rowIndex);
    }

    private List<Integer> nextRow(List<Integer> previous, int rowIndex) {
        if (rowIndex < 0) {
            return previous;
        }
        var row = new ArrayList<Integer>();
        for (var i = 0; i <= previous.size(); i++) {
            row.add(i == 0 || i == previous.size() ? 1 : previous.get(i - 1) + previous.get(i));
        }
        return nextRow(row, rowIndex - 1);
    }

    // java Solution.java "3" "[1,3,3,1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String rowIndex = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rowIndex = %s",
                new Solution().getRow(Integer.parseInt(rowIndex)), expected, rowIndex));
        }
    }
}
