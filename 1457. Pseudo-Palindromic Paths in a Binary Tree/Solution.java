import java.util.*;
import java.util.stream.*;

class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        return (int) paths(root, new HashMap<>())
            .filter(path -> path.values().stream().filter(n -> n % 2 == 1).count() <= 1)
            .count();
    }

    private Stream<Map<Integer, Integer>> paths(TreeNode node, Map<Integer, Integer> vals) {
        if (node == null) {
            return Stream.of();
        }
        vals.merge(node.val, 1, Integer::sum);
        if (node.left == null && node.right == null) {
            return Stream.of(vals);
        }
        return Stream.of(node.left, node.right)
            .filter(child -> child != null)
            .flatMap(child -> paths(child, new HashMap<>(vals)));
    }

    // java Solution.java "[2,3,1,3,1,null,1]" "2" "[2,1,1,1,3,null,null,null,null,null,1]" "1" "[9]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().pseudoPalindromicPaths(treeNode(root)), expected, root));
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
