import java.util.*;

class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        var vals = new ArrayList<Integer>();
        if (root == null) {
            return vals;
        }
        var nodes = new Stack<Object>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            var item = nodes.peek();
            nodes.pop();
            if (item == null) {
                continue;
            }
            if (item instanceof TreeNode) {
                TreeNode node = (TreeNode) item;
                nodes.push(node.val);
                nodes.push(node.right);
                nodes.push(node.left);
            } else {
                vals.add((Integer) item);
            }
        }
        return vals;
    }

    // java Solution.java "[1,null,2,3]" "[3,2,1]" "[]" "[]" "[1]" "[1]" "[1,2]" "[2,1]" "[1,null,2]" "[2,1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().postorderTraversal(treeNode(root)), expected, root));
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
