package uk.matvey.play.leet0110.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        boolean result = new Solution().isBalanced(root);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 2, 2, 3, 3, null, null, 4, 4);

        boolean result = new Solution().isBalanced(root);

        assertThat(result).isFalse();
    }
}
