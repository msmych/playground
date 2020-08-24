import java.util.*;

class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return partialSums(root.left).contains(sum - root.val) || partialSums(root.right).contains(sum - root.val);
    }

    private Set<Integer> partialSums(TreeNode node) {
        var partialSums = new HashSet<Integer>();
        if (node == null) {
            return partialSums;
        }
        Set<Integer> leftSet = partialSums(node.left), rightSet = partialSums(node.right);
        if (leftSet.isEmpty() && rightSet.isEmpty()) {
            partialSums.add(node.val);
        }
        for (var v : leftSet) {
            partialSums.add(v + node.val);
        }
        for (var v : rightSet) {
            partialSums.add(v + node.val);
        }
        return partialSums;
    }

    // java Solution.java "[5,4,8,11,null,13,4,7,2,null,null,null,1]" "22" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root = args[i], sum = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s, sum = %s",
                new Solution().hasPathSum(treeNode(root), Integer.parseInt(sum)), expected, root, sum));
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
