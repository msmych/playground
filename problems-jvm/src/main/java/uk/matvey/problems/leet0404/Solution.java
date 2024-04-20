package uk.matvey.problems.leet0404;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int sumOfLeftLeaves(TreeNode root) {
        return nextSum(root, false);
    }

    private int nextSum(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }
        return nextSum(node.left, true) + nextSum(node.right, false);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        var result = new Solution().sumOfLeftLeaves(root);

        assertThat(result).isEqualTo(24);
    }
}