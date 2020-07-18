import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var adjustment = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses], topologicalOrder = new int[numCourses];
        for (var prerequisite : prerequisites) {
            int dest = prerequisite[0], source = prerequisite[1];
            var list = adjustment.getOrDefault(source, new ArrayList<>());
            list.add(dest);
            adjustment.put(source, list);
            indegree[dest]++;
        }
        var queue = new LinkedList<Integer>();
        for (var i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        var i = 0;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            topologicalOrder[i++] = node;
            if (adjustment.containsKey(node)) {
                for (var neighbor : adjustment.get(node)) {
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return i == numCourses ? topologicalOrder : new int[0];
    }

    // java Solution.java "2" "[[1,0]]" "[0,1]" "4" "[[1,0],[2,0],[3,1],[3,2]]" "[0,1,2,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String numCourses = args[i], prerequisites = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numCourses = %s, prerequisites = %s",
                string(new Solution().findOrder(Integer.parseInt(numCourses), array(prerequisites))), expected, numCourses, prerequisites));
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
