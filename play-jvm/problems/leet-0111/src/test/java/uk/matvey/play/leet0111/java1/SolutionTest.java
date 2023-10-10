package uk.matvey.play.leet0111.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        int result = new Solution().minDepth(root);

        assertThat(result).isEqualTo(2);
    }
}
