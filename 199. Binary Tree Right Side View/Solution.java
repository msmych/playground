import java.util.List;
import java.util.ArrayList;

class Solution {

    private final List<Integer> view = new ArrayList<>();
    private int depth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        next(root, 1);
        return view;
    }

    private void next(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > this.depth) {
            view.add(node.val);
            this.depth = depth;
        }
        next(node.right, depth + 1);
        next(node.left, depth + 1);
    }


    // java Solution.java "[1,2,3,null,5,null,4]" "[1, 3, 4]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                new Solution().rightSideView(treeNode(root)), expected, root));
        }
    }

    private static TreeNode treeNode(String s) {
        String[] vals = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        if (vals[0].equals("[]")) return null;
        TreeNode[] nodes = new TreeNode[vals.length];
        nodes[0] = new TreeNode(Integer.parseInt(vals[0]));
        for (int i = 1, k = 1; i < vals.length; i += 2) {
            TreeNode parent = nodes[i - k] == null ? nodes[i - --k] : nodes[i - k++];
            parent.left = vals[i].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i]));
            nodes[i] = parent.left;
            if (i + 1 >= vals.length) break;
            parent.right = vals[i + 1].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i + 1]));
            nodes[i + 1] = parent.right;
        }
        return nodes[0];
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
