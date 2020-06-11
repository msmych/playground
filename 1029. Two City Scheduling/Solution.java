import static java.util.Arrays.*;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        var min = 0;
        var refund = new int[costs.length];
        for (var i = 0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
            min += costs[i][0];
        }
        sort(refund);
        for (var i = 0; i < costs.length / 2; i++) {
            min += refund[i];
        }
        return min;
    }

    // java Solution.java "[[10,20],[30,200],[400,50],[30,20]]" "110"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String costs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: costs = %s",
                new Solution().twoCitySchedCost(array(costs)), expected, costs));
        }
    }

    private static int[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new int[0][0];
        int[][] arr = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(elements[j]);
        }
        return arr;
    }
}
