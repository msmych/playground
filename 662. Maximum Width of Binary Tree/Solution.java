import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        var max = 0;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peekFirst() == null) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() == null) {
                queue.pollLast();
            }
            if (queue.size() > max) {
                max = queue.size();
            }
            for (var i = queue.size(); i > 0; i--) {
                var node = queue.poll();
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return max;
    }

    // java Solution.java "[1,3,2,5,3,null,9]" "4" "[1,3,null,5,3]" "2" "[1,3,2,5]" "2" "[1,3,2,5,null,null,9,6,null,null,7]" "8"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().widthOfBinaryTree(treeNode(root)), expected, root));
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
