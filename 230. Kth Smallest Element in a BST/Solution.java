import java.util.*;

class Solution {

    public int kthSmallest(TreeNode root, int k) {
        var stack = new Stack<TreeNode>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }

    // java Solution.java "[3,1,4,null,2]" "1" "1" "[5,3,6,2,4,null,null,1]" "3" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, k = %s",
                new Solution().kthSmallest(treeNode(root), Integer.parseInt(k)), expected, root, k));
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
