package uk.matvey.play.leet0515.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        var largest = new ArrayList<Integer>();
        if (root == null) {
            return largest;
        }
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left == null && node.right == null) {
                    continue;
                }
                queue.offer(node.right);
                queue.offer(node.left);
            }
            largest.add(max);
        }
        return largest;
    }
}
