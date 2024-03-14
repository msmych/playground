package uk.matvey.problems.leet0110;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left, 1) - depth(root.right, 1)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node, int d) {
        if (node == null) {
            return d;
        }
        return Math.max(depth(node.left, d + 1), depth(node.right, d + 1));
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        boolean result = new Solution().isBalanced(root);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 2, 2, 3, 3, null, null, 4, 4);

        boolean result = new Solution().isBalanced(root);

        assertThat(result).isFalse();
    }
}
