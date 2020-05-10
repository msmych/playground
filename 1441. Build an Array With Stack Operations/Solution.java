import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        var arr = new ArrayList<String>();
        for (int i = 0, e = 1; i < target.length && e <= n; e++) {
            arr.add("Push");
            if (target[i] == e) {
                i++;
            } else {
                arr.add("Pop");
            }
        }
        return arr;
    }

    // java Solution.java "[1,3]" "3" "[Push,Push,Pop,Push]" "[1,2,3]" "3" "[Push,Push,Push]" "[1,2]" "4" "[Push,Push]" "[2,3,4]" "4" "[Push,Pop,Push,Push,Push]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String target = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: target = %s, n = %s",
                new Solution().buildArray(array(target), Integer.parseInt(n)), expected, target, n));
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
}
