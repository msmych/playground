package uk.matvey.problems.leet;

import java.util.Objects;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public static TreeNode treeNode(Integer... vals) {
        if (vals.length == 0) return null;
        var nodes  = new TreeNode[vals.length];
        var stack = new Stack<TreeNode>();
        for (int i = vals.length - 1, n = 0; i >= 0; i--, n++) {
            var node = (vals[i] == null) ? null : new TreeNode(vals[i]);
            nodes[vals.length - n - 1] = node;
            stack.push(node);
        }
        var root = stack.pop();
        for (var node : nodes) {
            if (node != null) {
                if (!stack.empty()) node.left = stack.pop();
                if (!stack.empty()) node.right = stack.pop();
            }
        }
        return root;
    }
}
