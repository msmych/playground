package uk.matvey.play.leet0094.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, null, 2, 3);

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly(1, 3, 2);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode();

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly();
    }

    @Test
    public void case3() {
        var root = TreeNode.treeNode(1);

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly(1);
    }
}
