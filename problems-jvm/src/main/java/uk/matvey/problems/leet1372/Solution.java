package uk.matvey.problems.leet1372;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var rtl = new HashMap<Integer, Boolean>();
        rtl.put(0, false);
        var ltr = new HashMap<Integer, Boolean>();
        ltr.put(0, true);
        return Math.max(nextZigZag(root.left, rtl, false), nextZigZag(root.right, ltr, true));
    }

    private int nextZigZag(TreeNode node, Map<Integer, Boolean> map, boolean isRight) {
        if (node == null) {
            return map.keySet().stream().max(Comparator.naturalOrder()).orElse(0);
        }
        if (isRight) {
            map = map.entrySet().stream()
                .filter(e -> e.getValue() == (e.getKey() % 2 == 0))
                .collect(Collectors.toMap(e -> e.getKey() + 1, Map.Entry::getValue));
            map.put(0, false);
            var ltr = new HashMap<Integer, Boolean>();
            ltr.put(0, true);
            return Math.max(nextZigZag(node.left, map, false), nextZigZag(node.right, ltr, true));
        } else {
            map = map.entrySet().stream()
                .filter(e -> e.getValue() == (e.getKey() % 2 == 1))
                .collect(Collectors.toMap(e -> e.getKey() + 1, Map.Entry::getValue));
            map.put(0, true);
            var rtl = new HashMap<Integer, Boolean>();
            rtl.put(0, false);
            return Math.max(nextZigZag(node.left, rtl, false), nextZigZag(node.right, map, true));
        }
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1);

        int result = new Solution().longestZigZag(root);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(1, 1, 1, null, 1, null, null, 1, 1, null, 1);

        int result = new Solution().longestZigZag(root);

        assertThat(result).isEqualTo(4);
    }
}
