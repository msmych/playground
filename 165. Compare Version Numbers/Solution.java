import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public int compareVersion(String version1, String version2) {
        Integer[] revisions1 = getRevisions(version1), revisions2 = getRevisions(version2);
        for (var i = 0; i < min(revisions1.length, revisions2.length); i++) {
            int r1 = revisions1[i], r2 = revisions2[i];
            if (r1 != r2) {
                return r1 > r2 ? 1 : -1;
            }
        }
        if (revisions1.length > revisions2.length) {
            return compareExtraRevisions(revisions1, revisions2);
        } else if (revisions2.length > revisions1.length) {
            return - compareExtraRevisions(revisions2, revisions1);
        }
        return 0;
    }

    private Integer[] getRevisions(String version1) {
        return stream(version1.split("\\."))
                .map(Integer::valueOf)
                .collect(toList())
                .toArray(new Integer[]{});
    }

    private int compareExtraRevisions(Integer[] revisions1, Integer[] revisions2) {
        return stream(revisions1).skip(revisions2.length).anyMatch(r -> r > 0) ? 1 : 0;
    }

    // java Solution.java "0.1" "1.1" "-1" "1.0.1" "1" "1" "7.5.2.4" "7.5.3" "-1" "1.01" "1.001" "0" "1.0" "1.0.0" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String version1 = args[i], version2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: version1 = %s, version2 = %s",
                new Solution().compareVersion(version1, version2), expected, version1, version2));
        }
    }
}
