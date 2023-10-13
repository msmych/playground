package uk.matvey.play.leet0112.java1;

import uk.matvey.play.types.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return partialSums(root.left).contains(sum - root.val) || partialSums(root.right).contains(sum - root.val);
    }

    private Set<Integer> partialSums(TreeNode node) {
        var partialSums = new HashSet<Integer>();
        if (node == null) {
            return partialSums;
        }
        Set<Integer> leftSet = partialSums(node.left), rightSet = partialSums(node.right);
        if (leftSet.isEmpty() && rightSet.isEmpty()) {
            partialSums.add(node.val);
        }
        for (var v : leftSet) {
            partialSums.add(v + node.val);
        }
        for (var v : rightSet) {
            partialSums.add(v + node.val);
        }
        return partialSums;
    }
}
