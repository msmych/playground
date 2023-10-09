package uk.matvey.play.leet0107.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        List<List<Integer>> result = new Solution().levelOrderBottom(root);

        assertThat(result).containsExactly(List.of(15, 7), List.of(9, 20), List.of(3));
    }
}
