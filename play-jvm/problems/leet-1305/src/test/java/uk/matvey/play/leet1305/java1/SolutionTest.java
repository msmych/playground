package uk.matvey.play.leet1305.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root1 = TreeNode.treeNode(2, 1, 4);
        var root2 = TreeNode.treeNode(1, 0, 3);

        List<Integer> result = new Solution().getAllElements(root1, root2);

        assertThat(result).containsExactly(0, 1, 1, 2, 3, 4);
    }

    @Test
    public void case2() {
        var root1 = TreeNode.treeNode(0, -10, 10);
        var root2 = TreeNode.treeNode(5, 1, 7, 0, 2);

        List<Integer> result = new Solution().getAllElements(root1, root2);

        assertThat(result).containsExactly(-10, 0, 0, 1, 2, 5, 7, 10);
    }

    @Test
    public void case3() {
        var root1 = TreeNode.treeNode();
        var root2 = TreeNode.treeNode(5, 1, 7, 0, 2);

        List<Integer> result = new Solution().getAllElements(root1, root2);

        assertThat(result).containsExactly(0, 1, 2, 5, 7);
    }

    @Test
    public void case4() {
        var root1 = TreeNode.treeNode(0, -10, 10);
        var root2 = TreeNode.treeNode();

        List<Integer> result = new Solution().getAllElements(root1, root2);

        assertThat(result).containsExactly(-10, 0, 10);
    }

    @Test
    public void case5() {
        var root1 = TreeNode.treeNode(1, null, 8);
        var root2 = TreeNode.treeNode(8, 1);

        List<Integer> result = new Solution().getAllElements(root1, root2);

        assertThat(result).containsExactly(1, 1, 8, 8);
    }
}
