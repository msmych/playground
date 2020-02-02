import static java.util.stream.IntStream.range;
import static java.util.Comparator.comparingInt;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        return range(0, mat.length)
            .mapToObj(i -> soldiers(i, mat[i]))
            .sorted(comparingInt(s -> s[1]))
            .limit(k)
            .mapToInt(s -> s[0])
            .toArray();
    }

    private int[] soldiers(int index, int[] row) {
        int count = 0;
        for (int i = 0; i < row.length && row[i] == 1; i++) {
            count++;
        }
        return new int[]{index, count};
    }

    // java Solution.java "[[1,1,0,0,0], [1,1,1,1,0], [1,0,0,0,0], [1,1,0,0,0], [1,1,1,1,1]]" "3" "[2,0,3]" "[[1,0,0,0], [1,1,1,1], [1,0,0,0], [1,0,0,0]]" "2" "[0,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String mat = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: mat = %s, k = %s",
                string(new Solution().kWeakestRows(array(mat), Integer.parseInt(k))), expected, mat, k));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
