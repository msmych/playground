import java.util.*;

import static java.util.Comparator.*;

class Solution {

    private List<Integer> vals = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        traverse(root1);
        traverse(root2);
        vals.sort(naturalOrder());
        return vals;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        vals.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    // java Solution.java "[2,1,4]" "[1,0,3]" "[0,1,1,2,3,4]" "[0,-10,10]" "[5,1,7,0,2]" "[-10,0,0,1,2,5,7,10]" "[]" "[5,1,7,0,2]" "[0,1,2,5,7]" "[0,-10,10]" "[]" "[-10,0,10]" "[1,null,8]" "[8,1]" "[1,1,8,8]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String root1 = args[i], root2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root1 = %s, root2 = %s",
                new Solution().getAllElements(treeNode(root1), treeNode(root2)), expected, root1, root2));
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
