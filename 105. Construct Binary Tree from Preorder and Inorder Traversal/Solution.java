import java.util.*;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0], rootIndex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        var nextPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        if (rootIndex == -1) {
            return buildTree(nextPreorder, inorder);
        }
        var node = new TreeNode(rootValue);
        node.left = buildTree(nextPreorder, Arrays.copyOf(inorder, rootIndex));
        node.right = buildTree(nextPreorder, Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return node;
    }

    // java Solution.java "[3,9,20,15,7]" "[9,3,15,20,7]" "[3, 9, 20, null, null, 15, 7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String preorder = args[i], inorder = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: preorder = %s, inorder = %s",
                string(new Solution().buildTree(intArr(preorder), intArr(inorder))), expected, preorder, inorder));
        }
    }

    private static int[] intArr(String s) {
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
