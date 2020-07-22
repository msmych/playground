import java.util.*;

import static java.util.Collections.*;

class Solution {

    private final Stack<TreeNode> stack = new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
          return emptyList();
        }
        var zigzag = new ArrayList<List<Integer>>();
        stack.push(root);
        var count = 0;
        while (!stack.isEmpty()) {
            var row = new ArrayList<Integer>();
            var next = new ArrayList<TreeNode>();
            for (var size = stack.size(); size > 0; size--) {
                var node = stack.pop();
                if (node == null) {
                  continue;
                }
                if (count % 2 == 0) {
                    row.add(node.val);
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    row.add(node.val);
                    next.add(node.right);
                    next.add(node.left);
                }
            }
            stack.addAll(next);
            if (!row.isEmpty()) {
                zigzag.add(row);
            }
            count++;
        }
        return zigzag;
    }

    // java Solution.java "[3,9,20,null,null,15,7]" "[[3],[20,9],[15,7]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().zigzagLevelOrder(treeNode(root)), expected, root));
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
