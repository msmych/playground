import java.util.*;

class Solution {

    public String simplifyPath(String path) {
        var dirs = new Stack<String>();
        for (var dir : path.split("/")) {
            if (dir.equals("..")) {
                if (!dirs.isEmpty()) {
                    dirs.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                dirs.push(dir);
            }
        }
        return '/' + String.join("/", dirs);
    }

    // java Solution.java "/home/" "/home/" "/../" "/" "/home//foo/" "/home/foo" "/a/./b/../../c/" "/c" "/a/../../b/../c//.//" "/c" "/a//b////c/d//././/.." "/a/b/c"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String path = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: path = %s",
                new Solution().simplifyPath(path), expected, path));
        }
    }
}
