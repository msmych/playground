class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return nextSum(root, null, null);
    }

    private int nextSum(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return 0;
        }
        if (parent == null) {
            return nextSum(node.left, node, null) + nextSum(node.right, node, null);
        }
        return nextSum(node.left, node, parent) + nextSum(node.right, node, parent) +
            (grandparent != null && grandparent.val % 2 == 0 ? node.val : 0);
    }

    // java Solution.java 6,7,8,2,7,1,3,9,null,1,4,null,null,null,5 18
    public static void main(String... args) {
        Solution solution = new Solution();
        for (int i = 0; i < args.length; i += 2) {
            String root = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: root = %s",
                solution.sumEvenGrandparent(TreeNode.deserialize(root)), expected, root));
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    static TreeNode deserialize(String s) {
        String[] vals = s.split(",");
        if (vals[0].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[0]));
        TreeNode[] nodes = new TreeNode[vals.length];
        nodes[0] = node;
        int k = 1;
        for (int i = 1; i < vals.length - 1; i += 2) {
            TreeNode parent = nodes[i - k];
            k++;
            if (parent == null) {
                continue;
            }
            parent.left = vals[i].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i]));
            nodes[i] = parent.left;
            parent.right = vals[i + 1].equals("null") ? null : new TreeNode(Integer.parseInt(vals[i + 1]));
            nodes[i + 1] = parent.right;
        }
        return nodes[0];
    }
}
