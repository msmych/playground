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
            "[1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3]"
        };
        for (String tree : trees) {
            TreeNode treeNode = treeNode(tree);
            System.out.println(String.format("%s | %s", string(treeNode), tree));
        }
    }

    private static TreeNode treeNode(String s) {
        String[] vals = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        if (vals[0].isEmpty()) return null;
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
