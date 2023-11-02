package uk.matvey.play.leet2265.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {

    public int averageOfSubtree(TreeNode root) {
        var avg = avg(root);
        return avg.count;
    }

    private Avg avg(TreeNode node) {
        if (node == null) {
            return new Avg(0, 0, 0);
        }
        var left = avg(node.left);
        var right = avg(node.right);
        int nodesCount = 1 + left.nodesCount + right.nodesCount;
        int sum = node.val + left.sum + right.sum;
        return new Avg(
            nodesCount,
            sum,
            left.count + right.count + (sum / nodesCount == node.val ? 1 : 0)
        );
    }

    record Avg(
        int nodesCount,
        int sum,
        int count
    ) {
    }
}
