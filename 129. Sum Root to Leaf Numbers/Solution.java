import java.util.*;

class Solution {

    public int sumNumbers(TreeNode root) {
        return nextNumbers(root).stream().mapToInt(this::toNumber).sum();
    }

    private List<List<Integer>> nextNumbers(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        var numbers = new ArrayList<List<Integer>>();
        if (node.left == null && node.right == null) {
            return List.of(List.of(node.val));
        }
        for (var num : nextNumbers(node.left)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        for (var num : nextNumbers(node.right)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        return numbers;
    }

    private int toNumber(List<Integer> list) {
        var num = 0;
        for (var i = list.size() - 1; i >= 0; i--) {
            num *= 10;
            num += list.get(i);
        }
        return num;
    }

    // java Solution.java "[1,2,3]" "25" "[4,9,0,5,1]" "1026"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().sumNumbers(treeNode(root)), expected, root));
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
