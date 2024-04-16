package uk.matvey.problems.leet0623;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return null;
        }
        if (depth == 1) {
            var newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (depth == 2) {
            var left = root.left;
            var right = root.right;
            root.left = new TreeNode(val);
            root.left.left = left;
            root.right = new TreeNode(val);
            root.right.right = right;
            return root;
        }
        root.left = addOneRow(root.left, val, depth - 1);
        root.right = addOneRow(root.right, val, depth - 1);
        return root;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(4, 2, 6, 3, 1, 5);

        var result = new Solution().addOneRow(root, 1, 2);

        assertThat(result).isEqualTo(TreeNode.treeNode(4, 1, 1, 2, null, null, 6, 3, 1, 5));
    }

    @Test
    void case2() {
        var root = TreeNode.treeNode(4,2,null,3,1);

        var result = new Solution().addOneRow(root, 1, 3);

        assertThat(result).isEqualTo(TreeNode.treeNode(4, 2, null, 1, 1, 3, null, null, 1));
    }
}
