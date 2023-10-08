package uk.matvey.play.leet0103.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        List<List<Integer>> result = new Solution().zigzagLevelOrder(root);

        assertThat(result).containsExactly(List.of(3), List.of(20, 9), List.of(15, 7));
    }
}
