package uk.matvey.play.leet1372.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1);

        int result = new Solution().longestZigZag(root);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 1, 1, null, 1, null, null, 1, 1, null, 1);

        int result = new Solution().longestZigZag(root);

        assertThat(result).isEqualTo(4);
    }
}
