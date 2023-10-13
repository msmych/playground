package uk.matvey.play.leet0236.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);

        TreeNode result = new Solution().lowestCommonAncestor(root, TreeNode.treeNode(5), TreeNode.treeNode(1));

        assertThat(result.val).isEqualTo(3);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);

        TreeNode result = new Solution().lowestCommonAncestor(root, TreeNode.treeNode(5), TreeNode.treeNode(4));

        assertThat(result.val).isEqualTo(5);
    }
}
