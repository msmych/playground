import java.util.Stack;

class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        var nodes = preorder.split(",");
        var stack = new Stack<Boolean>();
        for (var i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                if (stack.isEmpty()) {
                    return false;
                }
                while (!stack.isEmpty() && stack.peek()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                    stack.push(true);
                } else if (i != nodes.length - 1) {
                    return false;
                }
            } else {
                stack.push(false);
            }
        }
        return stack.isEmpty();
    }

    // java Solution.java "9,3,4,#,#,1,#,#,2,#,6,#,#" "true" "1,#" "false" "9,#,#,1" "false" "1,#,#,#,#" false "#" true "9,3,4,#,#,1,#,#,#,2,#,6,#,#" false
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String preorder = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: preorder = %s",
                new Solution().isValidSerialization(preorder), expected, preorder));
        }
    }
}
