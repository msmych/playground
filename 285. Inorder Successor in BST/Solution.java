import java.util.*;

class Solution {

    private int val;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.val = p.val;
        return findSuccessor(root, null);
    }

    private TreeNode findSuccessor(TreeNode node, TreeNode parent) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            var leftMost = leftMost(node.right);
            return leftMost == null ? parent : leftMost;
        }
        return node.val > val ? findSuccessor(node.left, node) : findSuccessor(node.right, parent);
    }

    private TreeNode leftMost(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return leftMost(node.left);
    }

    // java Solution.java "[2,1,3]" "1" "2" "[5,3,6,2,4,null,null,1]" "6" "null" "[5,3,6,1,4,null,null,null,2]" 4 5 "[6,2,8,0,4,7,9,null,null,3,5]" 2 3
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], p = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, p = %s",
                string(new Solution().inorderSuccessor(treeNode(root), treeNode(p))), expected, root, p));
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

    private static String string(TreeNode root) {
        if (root == null) return "[]";
        String s = "";
        TreeNode[] nodes = new TreeNode[]{root};
        for (boolean hasNodes = true; hasNodes;) {
            hasNodes = false;
            String level = "";
            TreeNode[] next = new TreeNode[2 * nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                level += nodes[i] == null ? "null," : nodes[i].val + ",";
                if (nodes[i] != null) {
                    hasNodes = true;
                    next[2 * i] = nodes[i].left;
                    next[2 * i + 1] = nodes[i].right;
                }
            }
            while (level.endsWith("null,null,")) level = level.substring(0, level.length() - 5);
            s += level;
            nodes = next;
        }
        while (s.endsWith("null,")) s = s.substring(0, s.length() - 5);
        return "[" + s.substring(0, s.length() - 1) + "]";
    }
}

// ~~~ Please don't copy to LeetCode starting from this line
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
