package uk.matvey.problems.leet0112;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return partialSums(root.left).contains(sum - root.val) || partialSums(root.right).contains(sum - root.val);
    }

    private Set<Integer> partialSums(TreeNode node) {
        var partialSums = new HashSet<Integer>();
        if (node == null) {
            return partialSums;
        }
        Set<Integer> leftSet = partialSums(node.left), rightSet = partialSums(node.right);
        if (leftSet.isEmpty() && rightSet.isEmpty()) {
            partialSums.add(node.val);
        }
        for (var v : leftSet) {
            partialSums.add(v + node.val);
        }
        for (var v : rightSet) {
            partialSums.add(v + node.val);
        }
        return partialSums;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);

        boolean result = new Solution().hasPathSum(root, 22);

        assertThat(result).isTrue();
    }
}
