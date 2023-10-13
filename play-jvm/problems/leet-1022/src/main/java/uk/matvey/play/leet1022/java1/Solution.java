package uk.matvey.play.leet1022.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return nextSum(root, 0);
    }

    private int nextSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum <<= 1;
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return nextSum(node.left, sum) + nextSum(node.right, sum);
        }
    }
}
