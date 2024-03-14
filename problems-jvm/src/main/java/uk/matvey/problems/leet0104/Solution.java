package uk.matvey.problems.leet0104;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left), right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        int result = new Solution().maxDepth(root);

        assertThat(result).isEqualTo(3);
    }
}
