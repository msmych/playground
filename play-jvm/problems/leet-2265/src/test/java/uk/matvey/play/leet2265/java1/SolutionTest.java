package uk.matvey.play.leet2265.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        TreeNode root = TreeNode.treeNode(4, 8, 5, 0, 1, null, 6);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        TreeNode root = TreeNode.treeNode(1);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        TreeNode root = TreeNode.treeNode(1, null, 3, null, 1, null, 3);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(1);
    }
}
