import java.util.*;

class Solution {

    private int p, q;
    private TreeNode lca;
    private int level = Integer.MAX_VALUE;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p.val;
        this.q = q.val;
        search(root, 0);
        return lca;
    }

    private SearchResult search(TreeNode node, int level) {
        if (node == null) {
            return SearchResult.NONE;
        }
        SearchResult left = search(node.left, level + 1), right = search(node.right, level + 1);
        if (left == SearchResult.PQ || right == SearchResult.PQ) {
            return SearchResult.PQ;
        } else if (left == SearchResult.NONE && right == SearchResult.NONE) {
            if (node.val == p) {
                return SearchResult.P;
            }
            if (node.val == q) {
                return SearchResult.Q;
            }
            return SearchResult.NONE;
        } else if (left == SearchResult.P && right == SearchResult.Q || left == SearchResult.Q && right == SearchResult.P) {
            updateLca(node, level);
            return SearchResult.PQ;
        } else {
            if (node.val == p) {
                if (left == SearchResult.Q || right == SearchResult.Q) {
                    updateLca(node, level);
                    return SearchResult.PQ;
                }
                return SearchResult.P;
            }
            if (node.val == q) {
                if (left == SearchResult.P || right == SearchResult.P) {
                    updateLca(node, level);
                    return SearchResult.PQ;
                }
                return SearchResult.Q;
            }
            return left == SearchResult.NONE ? right : left;
        }
    }

    private void updateLca(TreeNode node, int level) {
        if (level < this.level) {
            lca = node;
            this.level = level;
        }
    }

    private enum SearchResult {NONE, P, Q, PQ}

    // java Solution.java "[3,5,1,6,2,0,8,null,null,7,4]" "5" "1" "3" "[3,5,1,6,2,0,8,null,null,7,4]" "5" "4" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String root = args[i], p = args[i + 1], q = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, p = %s, q = %s",
                string(new Solution().lowestCommonAncestor(treeNode(root), treeNode(p), treeNode(q))), expected, root, p, q));
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
