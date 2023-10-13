package uk.matvey.play.leet0114.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private final List<Integer> vals = new ArrayList<>();

    public void flatten(TreeNode root) {
        traverse(root);
        toLine(root, 0);
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        vals.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    private void toLine(TreeNode node, int index) {
        if (index == vals.size()) {
            return;
        }
        node.val = vals.get(index);
        node.left = null;
        if (node.right == null && index + 1 < vals.size()) {
            node.right = new TreeNode(0);
        }
        toLine(node.right, index + 1);
    }
}
