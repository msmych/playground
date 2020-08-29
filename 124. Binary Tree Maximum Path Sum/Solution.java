import java.util.*;

import static java.lang.Math.*;

class Solution {

    public int maxPathSum(TreeNode root) {
        var max = nextMax(root);
        if (max[0] == null) {
            return max[1];
        } else {
            return max(max[0], max[1]);
        }
    }

    private Integer[] nextMax(TreeNode node) {
        if (node == null) {
            return new Integer[]{null, null};
        }
        var left = nextMax(node.left);
        var right = nextMax(node.right);
        Integer complete = null;
        if (left[0] != null) {
            complete = left[0];
        }
        if (right[0] != null && (complete == null || right[0] > complete)) {
            complete = right[0];
        }
        if (left[1] != null && right[1] != null && (complete == null || left[1] + node.val + right[1] > complete)) {
            complete = left[1] + node.val + right[1];
        }
        if (left[1] != null && (complete == null || left[1] > complete)) {
            complete = left[1];
        }
        if (right[1] != null && (complete == null || right[1] > complete)) {
            complete = right[1];
        }
        var incomplete = node.val;
        if (left[1] != null && left[1] + node.val > incomplete) {
            incomplete = left[1] + node.val;
        }
        if (right[1] != null && node.val + right[1] > incomplete) {
            incomplete = node.val + right[1];
        }
        return new Integer[]{complete, incomplete};
    }

    // java Solution.java "[1,2,3]" "6" "[-10,9,20,null,null,15,7]" "42"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().maxPathSum(treeNode(root)), expected, root));
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
