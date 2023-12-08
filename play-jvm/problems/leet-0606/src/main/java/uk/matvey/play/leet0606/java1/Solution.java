package uk.matvey.play.leet0606.java1;

import uk.matvey.play.types.TreeNode;

public class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String s = String.valueOf(root.val);
        if (root.left != null || root.right != null) {
            s += root.left == null ? "()" : "(" + tree2str(root.left) + ")";
            if (root.right != null) {
                s += "(" + tree2str(root.right) + ")";
            }
        }
        return s;
    }
}
