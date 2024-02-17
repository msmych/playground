package uk.matvey.play.leet1379.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var original = TreeNode.treeNode(7, 4, 3, null, null, 6, 19);
        var cloned = TreeNode.treeNode(7, 4, 3, null, null, 6, 19);
        var target = TreeNode.treeNode(3);

        TreeNode result = new Solution().getTargetCopy(original, cloned, target);

        assertThat(result).isEqualTo(TreeNode.treeNode(3));
    }

    @Test
    public void case2() {
        var original = TreeNode.treeNode(7);
        var cloned = TreeNode.treeNode(7);
        var target = TreeNode.treeNode(7);

        TreeNode result = new Solution().getTargetCopy(original, cloned, target);

        assertThat(result).isEqualTo(TreeNode.treeNode(7));
    }

    @Test
    public void case3() {
        var original = TreeNode.treeNode(8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1);
        var cloned = TreeNode.treeNode(8, null, 6, null, 5, null, 4, null, 3, null, 2, null, 1);
        var target = TreeNode.treeNode(4);

        TreeNode result = new Solution().getTargetCopy(original, cloned, target);

        assertThat(result).isEqualTo(TreeNode.treeNode(4));
    }

    @Test
    public void case4() {
        var original = TreeNode.treeNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var cloned = TreeNode.treeNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        var target = TreeNode.treeNode(5);

        TreeNode result = new Solution().getTargetCopy(original, cloned, target);

        assertThat(result).isEqualTo(TreeNode.treeNode(5));
    }

    @Test
    public void case5() {
        var original = TreeNode.treeNode(1, 2, null, 3);
        var cloned = TreeNode.treeNode(1, 2, null, 3);
        var target = TreeNode.treeNode(2);

        TreeNode result = new Solution().getTargetCopy(original, cloned, target);

        assertThat(result).isEqualTo(TreeNode.treeNode(2));
    }
}
