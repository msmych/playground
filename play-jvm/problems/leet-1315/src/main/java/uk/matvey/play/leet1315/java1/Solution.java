package uk.matvey.play.leet1315.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
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
}
