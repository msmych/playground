package uk.matvey.problems.leet1022;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return nextSum(root, 0);
    }

    private int nextSum(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum <<= 1;
        sum += node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return nextSum(node.left, sum) + nextSum(node.right, sum);
        }
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 0, 1, 0, 1, 0, 1);

        int result = new Solution().sumRootToLeaf(root);

        assertThat(result).isEqualTo(22);
    }
}
