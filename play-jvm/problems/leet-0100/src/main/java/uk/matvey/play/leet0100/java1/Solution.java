package uk.matvey.play.leet0100.java1;

import uk.matvey.play.types.TreeNode;

import java.util.ArrayDeque;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (notEqualNodes(p, q)) {
            return false;
        }
        var deqp = new ArrayDeque<TreeNode>();
        var deqq = new ArrayDeque<TreeNode>();
        deqp.addLast(p);
        deqq.addLast(q);
        while (!deqp.isEmpty()) {
            p = deqp.removeFirst();
            q = deqq.removeFirst();
            if (notEqualNodes(p, q)) {
                return false;
            }
            if (p != null) {
                if (notEqualNodes(p.left, q.left)) {
                    return false;
                }
                if (p.left != null) {
                    deqp.addLast(p.left);
                    deqq.addLast(q.left);
                }
                if (notEqualNodes(p.right, q.right)) {
                    return false;
                }
                if (p.right != null) {
                    deqp.addLast(p.right);
                    deqq.addLast(q.right);
                }
            }
        }
        return true;
    }

    private boolean notEqualNodes(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null || q == null) {
            return true;
        }
        return p.val != q.val;
    }

}
