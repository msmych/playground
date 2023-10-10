package uk.matvey.play.leet0110.java1;

import uk.matvey.play.types.TreeNode;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return abs(depth(root.left, 1) - depth(root.right, 1)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node, int d) {
        if (node == null) {
            return d;
        }
        return max(depth(node.left, d + 1), depth(node.right, d + 1));
    }
}
