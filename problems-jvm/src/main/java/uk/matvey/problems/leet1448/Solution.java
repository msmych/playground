package uk.matvey.problems.leet1448;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int goodNodes(TreeNode root) {
        return nextGood(root, Integer.MIN_VALUE);
    }

    private int nextGood(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int good = node.val >= max ? 1 : 0;
        if (node.val > max) {
            max = node.val;
        }
        return good + nextGood(node.left, max) + nextGood(node.right, max);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(3, 1, 4, 3, null, 1, 5);

        var result = new Solution().goodNodes(root);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        var root = TreeNode.treeNode(3, 3, null, 4, 2);

        var result = new Solution().goodNodes(root);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        var root = TreeNode.treeNode(1);

        var result = new Solution().goodNodes(root);

        assertThat(result).isEqualTo(1);
    }
}