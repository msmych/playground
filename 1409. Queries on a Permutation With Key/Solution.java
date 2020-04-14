import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Collectors.toList;

class Solution {
    public int[] processQueries(int[] queries, int m) {
        var permutations = rangeClosed(1, m).boxed().collect(toList());
        for (var i = 0; i < queries.length; i++) {
            var index = permutations.indexOf(queries[i]);
            permutations.remove(index);
            permutations.add(0, queries[i]);
            queries[i] = index;
        }
        return queries;
    }

    // java Solution.java "[3,1,2,1]" "5" "[2,1,2,1]" "[4,1,2,2]" "4" "[3,1,2,0]" "[7,5,5,8,3]" "8" "[6,5,0,7,5]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String queries = args[i], m = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: queries = %s, m = %s",
                string(new Solution().processQueries(array(queries), Integer.parseInt(m))), expected, queries, m));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
