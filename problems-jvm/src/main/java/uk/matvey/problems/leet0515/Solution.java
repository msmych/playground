package uk.matvey.problems.leet0515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        var largest = new ArrayList<Integer>();
        if (root == null) {
            return largest;
        }
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (int i = queue.size(); i > 0; i--) {
                var node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.val > max) {
                    max = node.val;
                }
                if (node.left == null && node.right == null) {
                    continue;
                }
                queue.offer(node.right);
                queue.offer(node.left);
            }
            largest.add(max);
        }
        return largest;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 3, 2, 5, 3, null, 9);

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).containsExactly(1, 3, 9);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 2, 3);

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).containsExactly(1, 3);
    }

    @Test
    public void case3() {
        var root = TreeNode.treeNode();

        List<Integer> result = new Solution().largestValues(root);

        assertThat(result).isEmpty();
    }
}
