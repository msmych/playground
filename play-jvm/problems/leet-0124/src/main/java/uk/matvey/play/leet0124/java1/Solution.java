package uk.matvey.play.leet0124.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
    public int maxPathSum(TreeNode root) {
        var max = nextMax(root);
        if (max[0] == null) {
            return max[1];
        } else {
            return Math.max(max[0], max[1]);
        }
    }

    private Integer[] nextMax(TreeNode node) {
        if (node == null) {
            return new Integer[]{null, null};
        }
        var left = nextMax(node.left);
        var right = nextMax(node.right);
        Integer complete = null;
        if (left[0] != null) {
            complete = left[0];
        }
        if (right[0] != null && (complete == null || right[0] > complete)) {
            complete = right[0];
        }
        if (left[1] != null && right[1] != null && (complete == null || left[1] + node.val + right[1] > complete)) {
            complete = left[1] + node.val + right[1];
        }
        if (left[1] != null && (complete == null || left[1] > complete)) {
            complete = left[1];
        }
        if (right[1] != null && (complete == null || right[1] > complete)) {
            complete = right[1];
        }
        var incomplete = node.val;
        if (left[1] != null && left[1] + node.val > incomplete) {
            incomplete = left[1] + node.val;
        }
        if (right[1] != null && node.val + right[1] > incomplete) {
            incomplete = node.val + right[1];
        }
        return new Integer[]{complete, incomplete};
    }
}
