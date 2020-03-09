import java.util.Stack;

public class TreeParser {

    public static void main(String... args) {
        String[] trees = new String[]{
            "[6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]",
            "[1,2,3,4,5,6]",
            "[1,2,3,2,null,2,4]",
            "[1,null,3,null,4]",
            "[1,3,3,3,2]",
            "[1,3,null,null,2]",
            "[1,2,null,2,null,2]",
            "[1]",
            "[1,1,1]",
            "[]",
            "[1,2,3]",
            "[1,2,3,null,5,null,4]",
            "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]",
            "[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]",
            "[1,1,1,null,1,null,null,1,1,null,1]"
        };
        for (String tree : trees) {
            TreeNode treeNode = treeNode(tree);
            System.out.println(String.format("%s | %s", string(treeNode), tree));
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

    private static String string(TreeNode root) {
        if (root == null) return "[]";
        String s = "";
        TreeNode[] nodes = new TreeNode[]{root};
        for (boolean hasNodes = true; hasNodes;) {
            hasNodes = false;
            String level = "";
            TreeNode[] next = new TreeNode[2 * nodes.length];
            for (int i = 0; i < nodes.length; i++) {
                level += nodes[i] == null ? "null," : nodes[i].val + ",";
                if (nodes[i] != null) {
                    hasNodes = true;
                    next[2 * i] = nodes[i].left;
                    next[2 * i + 1] = nodes[i].right;
                }
            }
            while (level.endsWith("null,null,")) level = level.substring(0, level.length() - 5);
            s += level;
            nodes = next;
        }
        while (s.endsWith("null,")) s = s.substring(0, s.length() - 5);
        return "[" + s.substring(0, s.length() - 1) + "]";
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
