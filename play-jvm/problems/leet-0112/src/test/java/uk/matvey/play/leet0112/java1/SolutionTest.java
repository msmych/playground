package uk.matvey.play.leet0112.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);

        boolean result = new Solution().hasPathSum(root, 22);

        assertThat(result).isTrue();
    }
}
