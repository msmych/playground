import java.util.*;

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        var vals = new ArrayList<Integer>();
        var node = root;
        TreeNode pre;
        while (node != null) {
            if (node.left == null) {
                vals.add(node.val);
                node = node.right;
            } else {
                pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node;
                var temp = node;
                node = node.left;
                temp.left = null;
            }
        }
        return vals;
    }

    // java Solution.java "[1,null,2,3]" "[1,3,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().inorderTraversal(treeNode(root)), expected, root));
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
