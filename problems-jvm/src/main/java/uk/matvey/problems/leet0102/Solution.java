package uk.matvey.problems.leet0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final LinkedList<TreeNode> nodes = new LinkedList<>();
    private final List<List<Integer>> vals = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        nodes.offer(root);
        traverse();
        return vals;
    }

    private void traverse() {
        if (nodes.isEmpty()) {
            return;
        }
        var level = new ArrayList<Integer>();
        for (var i = nodes.size(); i > 0; i--) {
            var node = nodes.poll();
            if (node == null) {
                continue;
            }
            level.add(node.val);
            nodes.offer(node.left);
            nodes.offer(node.right);
        }
        if (!level.isEmpty()) {
            vals.add(level);
        }
        traverse();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        List<List<Integer>> result = new Solution().levelOrder(root);

        assertThat(result).containsExactly(List.of(3), List.of(9, 20), List.of(15, 7));
    }
}
