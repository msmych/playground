import static java.lang.Math.max;
import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Boolean> rtl = new HashMap<>();
        rtl.put(0, false);
        Map<Integer, Boolean> ltr = new HashMap<>();
        ltr.put(0, true);
        return max(nextZigZag(root.left, rtl, false), nextZigZag(root.right, ltr, true));
    }

    private int nextZigZag(TreeNode node, Map<Integer, Boolean> map, boolean isRight) {
        if (node == null) {
            return map.keySet().stream().max(naturalOrder()).orElse(0);
        }
        if (isRight) {
            map = map.entrySet().stream()
                .filter(e -> e.getValue() == (e.getKey() % 2 == 0))
                .collect(toMap(e -> e.getKey() + 1, Map.Entry::getValue));
            map.put(0, false);
            Map<Integer, Boolean> ltr = new HashMap<>();
            ltr.put(0, true);
            return max(nextZigZag(node.left, map, false), nextZigZag(node.right, ltr, true));
        } else {
            map = map.entrySet().stream()
                .filter(e -> e.getValue() == (e.getKey() % 2 == 1))
                .collect(toMap(e -> e.getKey() + 1, Map.Entry::getValue));
            map.put(0, true);
            Map<Integer, Boolean> rtl = new HashMap<>();
            rtl.put(0, false);
            return max(nextZigZag(node.left, rtl, false), nextZigZag(node.right, map, true));
        }
    }

    // java Solution.java "[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]" "3" "[1,1,1,null,1,null,null,1,1,null,1]" "4"
    public static void main(String... args) {
        new Solution().longestZigZag(treeNode("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]"));
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().longestZigZag(treeNode(root)), expected, root));
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
