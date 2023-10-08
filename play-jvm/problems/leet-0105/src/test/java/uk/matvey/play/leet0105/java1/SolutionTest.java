package uk.matvey.play.leet0105.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        var preorder = new int[]{3, 9, 20, 15, 7};
        var inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode result = new Solution().buildTree(preorder, inorder);

        assertThat(result).isEqualTo(TreeNode.treeNode(3, 9, 20, null, null, 15, 7));
    }
}
