package uk.matvey.problems.leet0100;

import java.util.ArrayDeque;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var p = TreeNode.treeNode(1, 2, 3);
        var q = TreeNode.treeNode(1, 2, 3);

        boolean result = new Solution().isSameTree(p, q);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var p = TreeNode.treeNode(1, 2);
        var q = TreeNode.treeNode(1, null, 2);

        boolean result = new Solution().isSameTree(p, q);

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        var p = TreeNode.treeNode(1, 2, 1);
        var q = TreeNode.treeNode(1, 1, 2);

        boolean result = new Solution().isSameTree(p, q);

        assertThat(result).isFalse();
    }
}
