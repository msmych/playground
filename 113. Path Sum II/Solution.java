import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        var paths = new ArrayList<List<Integer>>();
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                paths.add(List.of(root.val));
            }
            return paths;
        }
        for (var leftPath : pathSum(root.left, sum - root.val)) {
            var path = new ArrayList<>(leftPath);
            path.add(0, root.val);
            paths.add(path);
        }
        for (var rightPath : pathSum(root.right, sum - root.val)) {
            var path = new ArrayList<>(rightPath);
            path.add(0, root.val);
            paths.add(path);
        }
        return paths;
    }

    // java Solution.java "[5,4,8,11,null,13,4,7,2,null,null,5,1]" 22 "[[5,4,11,2],[5,8,4,5]]"
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
