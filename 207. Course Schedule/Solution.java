import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var courses = new HashMap<Integer, Set<Integer>>();
        for (var prerequisite : prerequisites) {
            courses.putIfAbsent(prerequisite[0], new HashSet<>());
            courses.putIfAbsent(prerequisite[1], new HashSet<>());
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }
        var visited = new HashSet<Integer>();
        while (!courses.values().stream().allMatch(Set::isEmpty)) {
            if (courses.entrySet().stream()
                .filter(e -> !visited.contains(e.getKey()))
                .map(Map.Entry::getValue)
                .noneMatch(Set::isEmpty))
                return false;
            var prerequisite = courses.entrySet().stream()
                .filter(e -> !visited.contains(e.getKey()))
                .filter(e -> e.getValue().isEmpty())
                .findAny()
                .map(Map.Entry::getKey)
                .get();
            for (var i : courses.entrySet().stream()
                .filter(e -> e.getValue().contains(prerequisite))
                .map(Map.Entry::getKey)
                .collect(toList())) {
                courses.get(i).remove(prerequisite);
            }
            visited.add(prerequisite);
        }
        return true;
    }

    // java Solution.java "2" "[[1,0]]" "true" "2" "[[1,0],[0,1]]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String numCourses = args[i], prerequisites = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numCourses = %s, prerequisites = %s",
                new Solution().canFinish(Integer.parseInt(numCourses), intArrArr(prerequisites)), expected, numCourses, prerequisites));
        }
    }

    private static int[][] intArrArr(String s) {
        s = s.replace(" ", "");
        if (s.equals("[[]]")) return new int[0][0];
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        var arr = new int[rows.length][];
        for (var i = 0; i < arr.length; i++) {
            var row = rows[i].replace("[", "").replace("]", "");
            if (row.isEmpty()) {
                arr[i] = new int[0];
                continue;
            }
            var els = row.split(",");
            arr[i] = new int[els.length];
            for (var j = 0; j < arr[i].length; j++) arr[i][j] = Integer.parseInt(els[j]);
        }
        return arr;
    }
}
