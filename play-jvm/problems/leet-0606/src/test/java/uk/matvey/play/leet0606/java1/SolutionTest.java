package uk.matvey.play.leet0606.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3, 4);

        String result = new Solution().tree2str(root);

        assertThat(result).isEqualTo("1(2(4))(3)");
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1,2,3,null,4);

        String result = new Solution().tree2str(root);

        assertThat(result).isEqualTo("1(2()(4))(3)");
    }
}
