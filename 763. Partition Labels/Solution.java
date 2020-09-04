import java.util.*;

class Solution {

    public List<Integer> partitionLabels(String S) {
        var intervals = new int[26][2];
        for (var i = 0; i < S.length(); i++) {
            var c = S.charAt(i) - 'a';
            if (intervals[c] == null) {
                intervals[c] = new int[]{ i, i };
            } else {
                intervals[c][1] = i;
            }
        }
        var partitions = new ArrayList<Integer>();
        int left = 0, right = 0;
        while (left < S.length()) {
            right = intervals[S.charAt(left) - 'a'][1];
            for (var i = left + 1; i < right; i++) {
                var r = intervals[S.charAt(i) - 'a'][1];
                if (r > right) {
                    right = r;
                }
            }
            partitions.add(right - left + 1);
            left = right + 1;
        }
        return partitions;
    }

    // java Solution.java "ababcbacadefegdehijhklij" "[9,7,8]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String S = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: S = %s",
                new Solution().partitionLabels(S), expected, S));
        }
    }
}
