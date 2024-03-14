package uk.matvey.problems.leet0114;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final List<Integer> vals = new ArrayList<>();

    public void flatten(TreeNode root) {
        traverse(root);
        toLine(root, 0);
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        vals.add(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    private void toLine(TreeNode node, int index) {
        if (index == vals.size()) {
            return;
        }
        node.val = vals.get(index);
        node.left = null;
        if (node.right == null && index + 1 < vals.size()) {
            node.right = new TreeNode(0);
        }
        toLine(node.right, index + 1);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 5, 3, 4, null, 6);

        new Solution().flatten(root);

        assertThat(root).isEqualTo(TreeNode.treeNode(1, null, 2, null, 3, null, 4, null, 5, null, 6));
    }
}
