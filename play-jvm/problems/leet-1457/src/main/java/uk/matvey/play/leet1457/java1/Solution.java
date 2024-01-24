package uk.matvey.play.leet1457.java1;

import uk.matvey.play.types.TreeNode;

import java.util.*;

public class Solution {

    private record NodePath(
        TreeNode node,
        int path
    ) {
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int count = 0;
        var stack = new ArrayDeque<NodePath>();
        stack.push(new NodePath(root, 0));
        while (!stack.isEmpty()) {
            var nodePath = stack.pop();
            var node = nodePath.node;
            int path = nodePath.path;
            if (node != null) {
                path ^= (1 << node.val);
                if (node.left == null && node.right == null) {
                    if ((path & (path - 1)) == 0) {
                        count++;
                    }
                } else {
                    stack.push(new NodePath(node.left, path));
                    stack.push(new NodePath(node.right, path));
                }
            }
        }
        return count;
    }
}
