package uk.matvey.play.leet0107.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        var vals = new Stack<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var row = new ArrayList<Integer>();
            for (var size = queue.size(); size > 0; size--) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                row.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!row.isEmpty()) {
                vals.push(row);
            }
        }
        var list = new ArrayList<List<Integer>>();
        while (!vals.isEmpty()) {
            list.add(vals.pop());
        }
        return list;
    }

}
