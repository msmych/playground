package uk.matvey.problems.leet0501;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] findMode(TreeNode root) {
        var occurrences = new HashMap<Integer, Integer>();
        var stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            occurrences.merge(node.val, 1, Integer::sum);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        int max = occurrences.values().stream().mapToInt(n -> n).max().orElse(0);
        var modesList = occurrences.entrySet().stream()
            .filter(e -> e.getValue().equals(max))
            .map(Map.Entry::getKey)
            .toList();
        var modes = new int[modesList.size()];
        for (int i = 0; i < modesList.size(); i++) {
            modes[i] = modesList.get(i);
        }
        return modes;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        TreeNode root = TreeNode.treeNode(1, null, 2, 2);

        int[] result = new Solution().findMode(root);

        assertThat(result).containsExactly(2);
    }

    @Test
    public void case2() {
        TreeNode root = TreeNode.treeNode(0);

        int[] result = new Solution().findMode(root);

        assertThat(result).containsExactly(0);
    }
}
