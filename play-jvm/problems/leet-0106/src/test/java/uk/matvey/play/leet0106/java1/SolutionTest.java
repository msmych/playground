package uk.matvey.play.leet0106.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        var inorder = new int[]{9, 3, 15, 20, 7};
        var postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode result = new Solution().buildTree(inorder, postorder);

        assertThat(result).isEqualTo(TreeNode.treeNode(3, 9, 20, null, null, 15, 7));
    }

}
