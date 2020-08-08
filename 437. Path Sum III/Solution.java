import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Solution {

    private int sum;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        return next(root, new ArrayList<>());
    }

    private int next(TreeNode node, List<Integer> sums) {
        if (node == null) {
            return 0;
        }
        sums = Stream.concat(Stream.of(0), sums.stream()).map(sum -> sum + node.val).collect(toList());
        return ((int) sums.stream().filter(sum -> sum == this.sum).count()) + 
            next(node.left, sums) +
            next(node.right, sums);
    }

    // java Solution.java "[10,5,-3,3,2,null,11,3,-2,null,1]" "8" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], sum = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, sum = %s",
                new Solution().pathSum(treeNode(root), Integer.parseInt(sum)), expected, root, sum));
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
