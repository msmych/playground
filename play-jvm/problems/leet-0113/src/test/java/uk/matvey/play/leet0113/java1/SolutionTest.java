package uk.matvey.play.leet0113.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);

        List<List<Integer>> result = new Solution().pathSum(root, 22);

        assertThat(result).containsExactly(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
    }
}
