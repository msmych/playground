package uk.matvey.play.leet0100.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

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
