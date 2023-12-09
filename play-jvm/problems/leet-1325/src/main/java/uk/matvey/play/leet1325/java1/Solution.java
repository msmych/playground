package uk.matvey.play.leet1325.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
    private int target;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        this.target = target;
        prune(root);
        return root.left == null && root.right == null && root.val == target ? null : root;
    }

    private boolean prune(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (prune(node.left)) {
            node.left = null;
        }
        if (prune(node.right)) {
            node.right = null;
        }
        return node.left == null && node.right == null && node.val == target;
    }
}
