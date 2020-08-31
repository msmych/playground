import java.util.*;

class Solution {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                var node = root.left == null ? root.right : root.left;
                if (node == null) {
                    return null;
                } else {
                    return node;
                }
            } else {
                var right = findRightSuccessor(root);
                root.val = right.val;
                root.right = deleteNode(root.right, right.val);
            }
        }
        return root;
    }

    private TreeNode findRightSuccessor(TreeNode root) {
        if (root == null) {
            return null;
        }
        var node = root.right;
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    // java Solution.java "[5,3,6,2,4,null,7]" "3" "[5,4,6,2,null,null,7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], key = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, key = %s",
                string(new Solution().deleteNode(treeNode(root), Integer.parseInt(key))), expected, root, key));
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
