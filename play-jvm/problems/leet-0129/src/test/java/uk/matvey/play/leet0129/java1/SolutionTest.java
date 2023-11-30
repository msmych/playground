package uk.matvey.play.leet0129.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3);

        int result = new Solution().sumNumbers(root);

        assertThat(result).isEqualTo(25);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(4,9,0,5,1);

        int result = new Solution().sumNumbers(root);

        assertThat(result).isEqualTo(1026);
    }
}
