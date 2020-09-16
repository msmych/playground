import java.util.*;

import static java.lang.Math.*;

class Solution {

    private double target;

    public int closestValue(TreeNode root, double target) {
        this.target = target;
        return nextClosest(root, root.val);
    }

    private int nextClosest(TreeNode node, int closest) {
        if (abs(target - node.val) < abs(target - closest)) {
            closest = node.val;
        }
        if (target < node.val && node.left != null) {
            return nextClosest(node.left, closest);
        }
        if (target > node.val && node.right != null) {
            return nextClosest(node.right, closest);
        }
        return closest;
    }

    // java Solution.java "[4,2,5,1,3]" "3.714286" "4" "[1,null,2]" 3.428571 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, target = %s",
                new Solution().closestValue(treeNode(root), Double.parseDouble(target)), expected, root, target));
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
