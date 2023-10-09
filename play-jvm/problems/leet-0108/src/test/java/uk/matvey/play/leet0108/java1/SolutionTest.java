package uk.matvey.play.leet0108.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode result = new Solution().sortedArrayToBST(nums);

        assertThat(result).isEqualTo(TreeNode.treeNode(0, -3, 9, -10, null, 5));
    }
}
