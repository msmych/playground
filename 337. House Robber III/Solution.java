import java.util.Stack;

import static java.lang.Math.max;

class Solution {
    public int rob(TreeNode root) {
        return robNext(root, false);        
    }

    private int robNext(TreeNode node, boolean parentRobbed) {
        if (node == null) {
            return 0;
        }
        if (parentRobbed) {
            return robNext(node.left, false) + robNext(node.right, false);
        }
        return max(node.val + robNext(node.left, true) + robNext(node.right, true),
            robNext(node.left, false) + robNext(node.right, false));
    }

    // java Solution.java "[3,2,3,null,3,null,1]" "7" "[3,4,5,1,3,null,1]" "9"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().rob(treeNode(root)), expected, root));
        }
    }

    private static TreeNode treeNode(String s) {
        s = s.replace("[", "").replace("]", "").replaceAll(" ", "");
        if (s.isEmpty()) return null;
        String[] elements = s.split(",");
        TreeNode[] nodes  = new TreeNode[elements.length];
        Stack<TreeNode> stack = new Stack<>();
        for (int i = elements.length - 1, n = 0; i >= 0; i--, n++) {
            TreeNode node = (elements[i].equals("null")) ? null : new TreeNode(Integer.parseInt(elements[i]));
            nodes[elements.length - n - 1] = node;
            stack.push(node);
        }
        TreeNode root = stack.pop();
        for (TreeNode node : nodes) {
            if (node != null) {
                if (!stack.empty()) node.left = stack.pop();
                if (!stack.empty()) node.right = stack.pop();
            }
        }
        return root;
    }
}

// ~~~ Please don't copy to LeetCode starting from this line
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
