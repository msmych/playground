import java.util.*;

class Solution {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return verify(root.left, null, root.val) && verify(root.right, root.val, null);
    }

    private boolean verify(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min || max != null && node.val >= max) {
            return false;
        }
        return verify(node.left, min, node.val) && verify(node.right, node.val, max);
    }

    // java Solution.java "[2,1,3]" "true" "[5,1,4,null,null,3,6]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().isValidBST(treeNode(root)), expected, root));
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
