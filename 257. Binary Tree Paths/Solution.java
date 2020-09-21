import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        var val = String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            return List.of(val);
        }
        return Stream.of(binaryTreePaths(root.left), binaryTreePaths(root.right))
            .flatMap(Collection::stream)
            .map(path -> val + "->" + path)
            .collect(toList());
    }

    // java Solution.java "[1,2,3,null,5]" "[1->2->5,1->3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().binaryTreePaths(treeNode(root)), expected, root));
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
