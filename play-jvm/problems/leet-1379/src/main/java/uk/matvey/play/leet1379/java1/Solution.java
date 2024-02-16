package uk.matvey.play.leet1379.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private TreeNode cloned;
    private TreeNode target;

    public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        this.cloned = cloned;
        this.target = target;
        return findTarget(original, new ArrayList<>());
    }

    private TreeNode findTarget(TreeNode node, List<Boolean> path) {
        if (node == null) {
            return null;
        }
        if (node == target) {
            var next = cloned;
            for (boolean direction : path) {
                next = direction ? next.right : next.left;
            }
            return next;
        }
        var leftPath = new ArrayList<>(path);
        leftPath.add(false);
        var left = findTarget(node.left, leftPath);
        if (left != null) {
            return left;
        }
        var rightPath = new ArrayList<>(path);
        rightPath.add(true);
        return findTarget(node.right, rightPath);
    }
}
