package uk.matvey.play.leet0104.java1;

import uk.matvey.play.types.TreeNode;

import static java.lang.Math.max;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left), right = maxDepth(root.right);
        return max(left, right) + 1;
    }
}
