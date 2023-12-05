package uk.matvey.play.leet1315.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5);

        int result = new Solution().sumEvenGrandparent(root);

        assertThat(result).isEqualTo(18);
    }
}
