package uk.matvey.problems.leet2265;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int averageOfSubtree(TreeNode root) {
        var avg = avg(root);
        return avg.count;
    }

    private Avg avg(TreeNode node) {
        if (node == null) {
            return new Avg(0, 0, 0);
        }
        var left = avg(node.left);
        var right = avg(node.right);
        int nodesCount = 1 + left.nodesCount + right.nodesCount;
        int sum = node.val + left.sum + right.sum;
        return new Avg(
            nodesCount,
            sum,
            left.count + right.count + (sum / nodesCount == node.val ? 1 : 0)
        );
    }

    record Avg(
        int nodesCount,
        int sum,
        int count
    ) {
    }
}

class SolutionTest {

    @Test
    public void case1() {
        TreeNode root = TreeNode.treeNode(4, 8, 5, 0, 1, null, 6);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        TreeNode root = TreeNode.treeNode(1);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        TreeNode root = TreeNode.treeNode(1, null, 3, null, 1, null, 3);

        int result = new Solution().averageOfSubtree(root);

        assertThat(result).isEqualTo(1);
    }
}
