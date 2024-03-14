package uk.matvey.problems.leet0103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final Stack<TreeNode> stack = new Stack<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return emptyList();
        }
        var zigzag = new ArrayList<List<Integer>>();
        stack.push(root);
        var count = 0;
        while (!stack.isEmpty()) {
            var row = new ArrayList<Integer>();
            var next = new ArrayList<TreeNode>();
            for (var size = stack.size(); size > 0; size--) {
                var node = stack.pop();
                if (node == null) {
                    continue;
                }
                if (count % 2 == 0) {
                    row.add(node.val);
                    next.add(node.left);
                    next.add(node.right);
                } else {
                    row.add(node.val);
                    next.add(node.right);
                    next.add(node.left);
                }
            }
            stack.addAll(next);
            if (!row.isEmpty()) {
                zigzag.add(row);
            }
            count++;
        }
        return zigzag;
    }

}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        List<List<Integer>> result = new Solution().zigzagLevelOrder(root);

        assertThat(result).containsExactly(List.of(3), List.of(20, 9), List.of(15, 7));
    }
}
