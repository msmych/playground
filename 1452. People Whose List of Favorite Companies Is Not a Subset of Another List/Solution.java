import java.util.*;

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        return null;
    }

    // java Solution.java "[[leetcode,google,facebook],[google,microsoft],[google,facebook],[google],[amazon]]" "[0,1,4]" "[[leetcode,google,facebook],[leetcode,amazon],[facebook,google]]" "[0,1]" "[[leetcode],[google],[facebook],[amazon]]" "[0,1,2,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String favoriteCompanies = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: favoriteCompanies = %s",
                new Solution().peopleIndexes(list(favoriteCompanies)), expected, favoriteCompanies));
        }
    }

    private static List<List<String>> list(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return List.of();
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return List.of();
        var list = new ArrayList<List<String>>();
        for (var i = 0; i < rows.length; i++) {
            var elements = rows[i].split(",");
            var row = new ArrayList<String>();
            for (var j = 0; j < elements.length; j++)
                row.add(elements[j]);
            list.add(row);
        }
        return list;
    }
}
