package uk.matvey.problems.leet0101;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 2, 3, 4, 4, 3);

        boolean symmetric = new Solution().isSymmetric(root);

        assertThat(symmetric).isTrue();
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 2, 2, null, 3, null, 3);

        boolean symmetric = new Solution().isSymmetric(root);

        assertThat(symmetric).isFalse();
    }
}
