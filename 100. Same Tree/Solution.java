import java.util.*;

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (notEqualNodes(p, q)) {
            return false;
        }
        var deqp = new ArrayDeque<TreeNode>();
        var deqq = new ArrayDeque<TreeNode>();
        deqp.addLast(p);
        deqq.addLast(q);
        while (!deqp.isEmpty()) {
            p = deqp.removeFirst();
            q = deqq.removeFirst();
            if (notEqualNodes(p, q)) {
                return false;
            }
            if (p != null) {
                if (notEqualNodes(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    deqp.addLast(p.left);
                    deqq.addLast(q.left);
                }
                if (notEqualNodes(p.right, q.right)) {
                    return false;
                }
                if (p.right != null) {
                    deqp.addLast(p.right);
                    deqq.addLast(q.right);
                }
            }
        }
        return true;
    }

    private boolean notEqualNodes(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null || q == null) {
            return true;
        }
        return p.val != q.val;
    }

    // java Solution.java "[1,2,3]" "[1,2,3]" "true" "[1,2]" "[1,null,2]" "false" "[1,2,1]" "[1,1,2]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String p = args[i], q = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: p = %s, q = %s",
                new Solution().isSameTree(treeNode(p), treeNode(q)), expected, p, q));
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
