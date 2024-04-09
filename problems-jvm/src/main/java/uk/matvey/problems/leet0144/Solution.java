package uk.matvey.problems.leet0144;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        var vals = new ArrayList<Integer>();
        if (root == null) {
            return vals;
        }
        var nodes = new Stack<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            var item = nodes.peek();
            nodes.pop();
            if (item == null) {
                continue;
            }
            if (item instanceof TreeNode node) {
                nodes.push(node.right);
                nodes.push(node.left);
                nodes.push(node.val);
            } else {
                vals.add((Integer) item);
            }
        }
        return vals;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var root = TreeNode.treeNode(1, null, 2, 3);

        var result = new Solution().preorderTraversal(root);

        assertThat(result).containsExactly(1, 2, 3);
    }
}
