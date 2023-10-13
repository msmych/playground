package uk.matvey.play.leet0114.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 5, 3, 4, null, 6);

        new Solution().flatten(root);

        assertThat(root).isEqualTo(TreeNode.treeNode(1, null, 2, null, 3, null, 4, null, 5, null, 6));
    }
}
