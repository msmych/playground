package uk.matvey.play.leet1022.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 0, 1, 0, 1, 0, 1);

        int result = new Solution().sumRootToLeaf(root);

        assertThat(result).isEqualTo(22);
    }
}
