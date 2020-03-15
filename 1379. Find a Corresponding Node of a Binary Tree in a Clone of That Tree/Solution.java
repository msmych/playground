import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

class Solution {

    private TreeNode cloned;
    private TreeNode target;

    public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        this.cloned = cloned;
        this.target = target;
        return findTarget(original, new ArrayList<>());
    }

    private TreeNode findTarget(TreeNode node, List<Boolean> path) {
        if (node == null) {
            return null;
        }
        if (node == target) {
            TreeNode next = cloned;
            for (Boolean direction : path) {
                next = direction ? next.right : next.left;
            }
            return next;
        }
        List<Boolean> leftPath = new ArrayList<>(path);
        leftPath.add(false);
        TreeNode left = findTarget(node.left, leftPath);
        if (left != null) {
            return left;
        }
        List<Boolean> rightPath = new ArrayList<>(path);
        rightPath.add(true);
        TreeNode right = findTarget(node.right, rightPath);
        return right;
    }


    // java Solution.java "[7,4,3,null,null,6,19]" "[7,4,3,null,null,6,19]" "3" "3" "[7]" "[7]" "7" "7" "[8,null,6,null,5,null,4,null,3,null,2,null,1]" "[8,null,6,null,5,null,4,null,3,null,2,null,1]" "4" "4" "[1,2,3,4,5,6,7,8,9,10]" "[1,2,3,4,5,6,7,8,9,10]" "5" "5" "[1,2,null,3]" "[1,2,null,3]" "2" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String original = args[i], cloned = args[i + 1], target = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: original = %s, cloned = %s, target = %s",
                string(new Solution().getTargetCopy(treeNode(original), treeNode(cloned), treeNode(target))), expected, original, cloned, target));
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
