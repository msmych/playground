package uk.matvey.problems.leet0988;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String smallestFromLeaf(TreeNode root) {
        return next(root, "");
    }

    private String next(TreeNode node, String suffix) {
        if (node == null) {
            return suffix;
        }
        var word = (char) ('a' + node.val) + suffix;
        if (node.left == null && node.right == null) {
            return word;
        }
        if (node.left == null) {
            return next(node.right, word);
        }
        if (node.right == null) {
            return next(node.left, word);
        }
        var left = next(node.left, word);
        var right = next(node.right, word);
        return left.compareTo(right) < 0 ? left : right;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(0, 1, 2, 3, 4, 3, 4);

        var result = new Solution().smallestFromLeaf(root);

        assertThat(result).isEqualTo("dba");
    }

    @Test
    void case2() {
        var root = TreeNode.treeNode(25, 1, 3, 1, 3, 0, 2);

        var result = new Solution().smallestFromLeaf(root);

        assertThat(result).isEqualTo("adz");
    }

    @Test
    void case3() {
        var root = TreeNode.treeNode(2, 2, 1, null, 1, 0, null, 0);

        var result = new Solution().smallestFromLeaf(root);

        assertThat(result).isEqualTo("abc");
    }

    @Test
    void case4() {
        var root = TreeNode.treeNode(0, null, 1);

        var result = new Solution().smallestFromLeaf(root);

        assertThat(result).isEqualTo("ba");
    }
}
