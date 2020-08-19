import java.util.*;

class Solution {

    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;

    public void recoverTree(TreeNode root) {
        traverse(root);
        var val = first.val;
        first.val = second.val;
        second.val = val;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (first == null && previous != null && previous.val >= node.val) {
            first = previous;
        }
        if (first != null && previous != null && previous.val >= node.val) {
            second = node;
        }
        previous = node;
        traverse(node.right);
    }

    // java Solution.java "[1,3,null,null,2]" "[3,1,null,null,2]" "[3,1,4,null,null,2]" "[2,1,4,null,null,3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var root = treeNode(args[i]);
            var expected = args[i + 1];
            new Solution().recoverTree(root);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                string(root), expected, args[i]));
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
