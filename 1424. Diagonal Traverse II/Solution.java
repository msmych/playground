import java.util.List;

import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    private static class Diagonal {
        int sum, row, val;

        Diagonal(int sum, int row, int val) {
            this.sum = sum;
            this.row = row;
            this.val = val;
        }
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        var diagonals = new HashSet<Diagonal>();
        for (var i = 0; i < nums.size(); i++) {
            var row = nums.get(i);
            for (var j = 0; j < row.size(); j++) {
                diagonals.add(new Diagonal(i + j, i, row.get(j)));
            }
        }
        return diagonals.stream()
            .sorted(comparingInt((Diagonal d) -> d.sum)
                .thenComparing(comparingInt((Diagonal d) -> d.row).reversed()))
            .mapToInt(d -> d.val)
            .toArray();
    }

    // java Solution.java "[[1,2,3],[4,5,6],[7,8,9]]" "[1,4,2,7,5,3,8,6,9]" "[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]" "[1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]" "[[1,2,3],[4],[5,6,7],[8],[9,10,11]]" "[1,4,2,5,3,8,6,9,7,10,11]" "[[1,2,3,4,5,6]]" "[1,2,3,4,5,6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                string(new Solution().findDiagonalOrder(list(nums))), expected, nums));
        }
    }

    private static List<List<Integer>> list(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new ArrayList<>();
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new ArrayList<>();
        var list = new ArrayList<List<Integer>>();
        for (int i = 0; i < rows.length; i++) {
            var elements = rows[i].split(",");
            var row = new ArrayList<Integer>();
            for (int j = 0; j < elements.length; j++)
                row.add(Integer.parseInt(elements[j]));
            list.add(row);
        }
        return list;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
