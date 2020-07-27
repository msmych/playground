import java.util.*;

class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1], rootIndex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        var nextPostorder = Arrays.copyOf(postorder, postorder.length - 1);
        if (rootIndex == -1) {
            return buildTree(inorder, nextPostorder);
        }
        var node = new TreeNode(rootValue);
        node.left = buildTree(Arrays.copyOf(inorder, rootIndex), nextPostorder);
        node.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length), nextPostorder);
        return node;
    }

    // java Solution.java "[9,3,15,20,7]" "[9,15,7,20,3]" "[3, 9, 20, null, null, 15, 7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String inorder = args[i], postorder = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: inorder = %s, postorder = %s",
                string(new Solution().buildTree(array(inorder), array(postorder))), expected, inorder, postorder));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
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

// ~~~ Please don't copy to LeetCode starting from this line
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
