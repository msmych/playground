package uk.matvey.play.leet0094.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        var vals = new ArrayList<Integer>();
        var node = root;
        TreeNode pre;
        while (node != null) {
            if (node.left == null) {
                vals.add(node.val);
                node = node.right;
            } else {
                pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node;
                var temp = node;
                node = node.left;
                temp.left = null;
            }
        }
        return vals;
    }
}
