import java.util.*;

class Solution {

    private final LinkedList<TreeNode> nodes = new LinkedList<>();
    private final List<List<Integer>> vals = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        nodes.offer(root);
        traverse();
        return vals;
    }

    private void traverse() {
        if (nodes.isEmpty()) {
            return;
        }
        var level = new ArrayList<Integer>();
        for (var i = nodes.size(); i > 0; i--) {
            var node = nodes.poll();
            if (node == null) {
                continue;
            }
            level.add(node.val);
            nodes.offer(node.left);
            nodes.offer(node.right);
        }
        if (!level.isEmpty()) {
            vals.add(level);
        }
        traverse();
    }

    // java Solution.java "[3,9,20,null,null,15,7]" "[[3],[9,20],[15,7]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().levelOrder(treeNode(root)), expected, root));
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
