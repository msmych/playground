package uk.matvey.play.leet1457.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.types.TreeNode;
import uk.matvey.play.utils.TestCaseReader;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        TreeNode root = TreeNode.treeNode(2, 3, 1, 3, 1, null, 1);

        int result = new Solution().pseudoPalindromicPaths(root);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        TreeNode root = TreeNode.treeNode(2, 1, 1, 1, 3, null, null, null, null, null, 1);

        int result = new Solution().pseudoPalindromicPaths(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        TreeNode root = TreeNode.treeNode(9);

        int result = new Solution().pseudoPalindromicPaths(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var arr = new TestCaseReader("case4").parseIntegerArr("root.txt");
        TreeNode root = TreeNode.treeNode(arr);

        int result = new Solution().pseudoPalindromicPaths(root);

        assertThat(result).isEqualTo(50000);
    }
}
