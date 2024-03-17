package uk.matvey.problems.leet1315;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int sumEvenGrandparent(TreeNode root) {
        return nextSum(root, null, null);
    }

    private int nextSum(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return 0;
        }
        if (parent == null) {
            return nextSum(node.left, node, null) + nextSum(node.right, node, null);
        }
        return nextSum(node.left, node, parent) + nextSum(node.right, node, parent) +
            (grandparent != null && grandparent.val % 2 == 0 ? node.val : 0);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5);

        int result = new Solution().sumEvenGrandparent(root);

        assertThat(result).isEqualTo(18);
    }
}
