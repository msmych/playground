import java.util.*;

class Solution {

    private static class File {
        int len;
        Map<String, File> files = new HashMap<>();

        File(int len) {
            this.len = len;
        }
    }

    public int lengthLongestPath(String input) {
        var file = new File(0);
        var stack = new Stack<String>();
        var max = 0;
        for (var row : input.split("\n")) {
            var name = row;
            var t = name.split("\t");
            var depth = t.length - 1;
            name = t[depth];
            for (var i = stack.size(); i > depth; i--) {
                stack.pop();
            }
            var f = file;
            for (var folder : stack) {
                f = f.files.get(folder);
            }
            var len = f.len + name.length();
            f.files.put(name, new File(len));
            if (name.contains(".")) {
                if (len + depth > max) {
                    max = len + depth;
                }
            } else {
                stack.push(name);
            }
        }
        return max;
    }

    // java Solution.java "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" "32" "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" 20
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String input = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: input = %s",
                new Solution().lengthLongestPath(input), expected, input));
        }
    }
}
