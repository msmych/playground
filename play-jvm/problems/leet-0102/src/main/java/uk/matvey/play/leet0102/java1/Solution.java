package uk.matvey.play.leet0102.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private final LinkedList<TreeNode> nodes = new LinkedList<>();
    private final List<List<Integer>> vals = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        nodes.offer(root);
        traverse();
        return vals;
    }

    private void traverse() {
        if (nodes.isEmpty()) {
            return;
        }
        var level = new ArrayList<Integer>();
        for (var i = nodes.size(); i > 0; i--) {
            var node = nodes.poll();
            if (node == null) {
                continue;
            }
            level.add(node.val);
            nodes.offer(node.left);
            nodes.offer(node.right);
        }
        if (!level.isEmpty()) {
            vals.add(level);
        }
        traverse();
    }
}
