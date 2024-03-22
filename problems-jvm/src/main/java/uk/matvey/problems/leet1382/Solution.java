package uk.matvey.problems.leet1382;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        var vals = traverse(root);
        return balanced(vals, 0, vals.size() - 1);
    }

    private List<Integer> traverse(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        var vals = traverse(node.left);
        vals.add(node.val);
        vals.addAll(traverse(node.right));
        return vals;
    }

    private TreeNode balanced(List<Integer> vals, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        var node = new TreeNode(vals.get(mid));
        node.left = balanced(vals, start, mid - 1);
        node.right = balanced(vals, mid + 1, end);
        return node;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(1, null, 2, null, 3, null, 4, null, null);

        TreeNode result = new Solution().balanceBST(root);

        assertThat(result).isEqualTo(TreeNode.treeNode(2, 1, 3, null, null, null, 4));
    }
}
