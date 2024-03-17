package uk.matvey.problems.leet0606;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        var s = String.valueOf(root.val);
        if (root.left != null || root.right != null) {
            s += root.left == null ? "()" : "(" + tree2str(root.left) + ")";
            if (root.right != null) {
                s += "(" + tree2str(root.right) + ")";
            }
        }
        return s;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3, 4);

        String result = new Solution().tree2str(root);

        assertThat(result).isEqualTo("1(2(4))(3)");
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1,2,3,null,4);

        String result = new Solution().tree2str(root);

        assertThat(result).isEqualTo("1(2()(4))(3)");
    }
}
