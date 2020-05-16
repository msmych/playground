import java.util.*;

class Solution {
    public int goodNodes(TreeNode root) {
        return nextGood(root, Integer.MIN_VALUE);
    }
    
    private int nextGood(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        var good = node.val >= max ? 1 : 0;
        if (node.val > max) {
            max = node.val;
        }
        return good + nextGood(node.left, max) + nextGood(node.right, max);
    }

    // java Solution.java "[3,1,4,3,null,1,5]" "4" "[3,3,null,4,2]" "3" "[1]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().goodNodes(treeNode(root)), expected, root));
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
