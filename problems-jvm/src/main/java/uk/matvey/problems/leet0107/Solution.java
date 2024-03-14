package uk.matvey.problems.leet0107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        var vals = new Stack<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            var row = new ArrayList<Integer>();
            for (var size = queue.size(); size > 0; size--) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                row.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!row.isEmpty()) {
                vals.push(row);
            }
        }
        var list = new ArrayList<List<Integer>>();
        while (!vals.isEmpty()) {
            list.add(vals.pop());
        }
        return list;
    }

}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(3, 9, 20, null, null, 15, 7);

        List<List<Integer>> result = new Solution().levelOrderBottom(root);

        assertThat(result).containsExactly(List.of(15, 7), List.of(9, 20), List.of(3));
    }
}
