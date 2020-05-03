import java.util.List;
import java.util.ArrayList;

class Solution {
    public String destCity(List<List<String>> paths) {
        return paths.stream()
            .map(path -> path.get(1))
            .filter(destination -> paths.stream()
                .map(path -> path.get(0))
                .noneMatch(destination::equals))
            .findAny()
            .orElseThrow();
    }

    // java Solution.java "[[London,New York],[New York,Lima],[Lima,Sao Paulo]]" "Sao Paulo" "[[B,C],[D,B],[C,A]]" "A" "[[A,Z]]" "Z"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String paths = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: paths = %s",
                new Solution().destCity(list(paths)), expected, paths));
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
