package uk.matvey.play.leet1305.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private final List<Integer> vals = new ArrayList<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        traverse(root1);
        traverse(root2);
        vals.sort(Comparator.naturalOrder());
        return vals;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        vals.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }
}
