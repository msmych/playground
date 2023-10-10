package uk.matvey.play.leet0111.java1;

import uk.matvey.play.types.TreeNode;

import static java.lang.Math.min;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left), right = minDepth(root.right);
        if (left == 0) {
            return 1 + right;
        }
        if (right == 0) {
            return 1 + left;
        }
        return 1 + min(left, right);
    }
}
