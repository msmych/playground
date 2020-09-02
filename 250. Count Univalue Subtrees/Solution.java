import java.util.*;

import static java.lang.Math.*;

class Solution {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = nextUnival(root.left, root.val);
        var right = nextUnival(root.right, root.val);
        return (left[0] > 0 || left[0] == 0 && left[1] == 0) && (right[0] > 0 || right[0] == 0 && right[1] == 0) ? left[0] + right[0] + 1 : max(left[0], left[1]) + max(right[0], right[1]);
    }

    private int[] nextUnival(TreeNode node, int parentVal) {
        if (node == null) {
            return new int[]{ 0, 0 };
        }
        var left = nextUnival(node.left, node.val);
        var right = nextUnival(node.right, node.val);
        if ((left[0] > 0 || left[0] == 0 && left[1] == 0) && (right[0] > 0 || right[0] == 0 && right[1] == 0)) {
            var total = left[0] + right[0] + 1;
            return node.val == parentVal ? new int[]{ total, 0 } : new int[]{ 0, total };
        }
        return new int[]{ 0, max(left[0], left[1]) + max(right[0], right[1]) };
    }


    // java Solution.java "[5,1,5,5,5,null,5]" "4" "[]" "0" "[5,5,5,5,5,null,5]" "6" "[1]" 1
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().countUnivalSubtrees(treeNode(root)), expected, root));
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
