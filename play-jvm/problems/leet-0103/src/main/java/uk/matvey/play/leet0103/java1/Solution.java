package uk.matvey.play.leet0103.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Collections.emptyList;

public class Solution {

    private final Stack<TreeNode> stack = new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return emptyList();
        }
        var zigzag = new ArrayList<List<Integer>>();
        stack.push(root);
        var count = 0;
        while (!stack.isEmpty()) {
            var row = new ArrayList<Integer>();
            var next = new ArrayList<TreeNode>();
            for (var size = stack.size(); size > 0; size--) {
                var node = stack.pop();
                if (node == null) {
                    continue;
                }
                if (count % 2 == 0) {
                    row.add(node.val);
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    row.add(node.val);
                    next.add(node.right);
                    next.add(node.left);
                }
            }
            stack.addAll(next);
            if (!row.isEmpty()) {
                zigzag.add(row);
            }
            count++;
        }
        return zigzag;
    }

}
