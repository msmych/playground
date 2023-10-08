package uk.matvey.play.leet0101.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
