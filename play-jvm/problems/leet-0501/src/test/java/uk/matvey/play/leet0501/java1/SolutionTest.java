package uk.matvey.play.leet0501.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        TreeNode root = TreeNode.treeNode(1, null, 2, 2);

        int[] result = new Solution().findMode(root);

        assertThat(result).containsExactly(2);
    }

    @Test
    public void case2() {
        TreeNode root = TreeNode.treeNode(0);

        int[] result = new Solution().findMode(root);

        assertThat(result).containsExactly(0);
    }
}
