package uk.matvey.play.leet0515.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 3, 2, 5, 3, null, 9);

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).containsExactly(1, 3, 9);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 2, 3);

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).containsExactly(1, 3);
    }

    @Test
    public void case3() {
        var root = TreeNode.treeNode();

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).isEmpty();
    }
}
