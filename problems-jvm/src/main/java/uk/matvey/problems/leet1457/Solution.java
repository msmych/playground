package uk.matvey.problems.leet1457;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;
import uk.matvey.problems.leet.TreeNode;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private record NodePath(
        TreeNode node,
        int path
    ) {
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int count = 0;
        var stack = new ArrayDeque<NodePath>();
        stack.push(new NodePath(root, 0));
        while (!stack.isEmpty()) {
            var nodePath = stack.pop();
            var node = nodePath.node;
            int path = nodePath.path;
            if (node != null) {
                path ^= (1 << node.val);
                if (node.left == null && node.right == null) {
                    if ((path & (path - 1)) == 0) {
                        count++;
                    }
                } else {
                    stack.push(new NodePath(node.left, path));
                    stack.push(new NodePath(node.right, path));
                }
            }
        }
        return count;
    }
}

class SolutionTest {

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
        var arr = new TestCaseReader("leet1457/case4").parseIntegerArr("root.txt");
        TreeNode root = TreeNode.treeNode(arr);

        int result = new Solution().pseudoPalindromicPaths(root);

        assertThat(result).isEqualTo(50000);
    }
}
