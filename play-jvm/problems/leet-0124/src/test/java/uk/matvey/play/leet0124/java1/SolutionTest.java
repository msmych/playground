package uk.matvey.play.leet0124.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3);

        int result = new Solution().maxPathSum(root);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(-10, 9, 20, null, null, 15, 7);

        int result = new Solution().maxPathSum(root);

        assertThat(result).isEqualTo(42);
    }
}
