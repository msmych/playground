package uk.matvey.problems.leet0129;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int sumNumbers(TreeNode root) {
        return nextNumbers(root).stream().mapToInt(this::toNumber).sum();
    }

    private List<List<Integer>> nextNumbers(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        var numbers = new ArrayList<List<Integer>>();
        if (node.left == null && node.right == null) {
            return List.of(List.of(node.val));
        }
        for (var num : nextNumbers(node.left)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        for (var num : nextNumbers(node.right)) {
            var next = new ArrayList<Integer>(num);
            next.add(node.val);
            numbers.add(next);
        }
        return numbers;
    }

    private int toNumber(List<Integer> list) {
        var num = 0;
        for (var i = list.size() - 1; i >= 0; i--) {
            num *= 10;
            num += list.get(i);
        }
        return num;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, 2, 3);

        int result = new Solution().sumNumbers(root);

        assertThat(result).isEqualTo(25);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode(4,9,0,5,1);

        int result = new Solution().sumNumbers(root);

        assertThat(result).isEqualTo(1026);
    }
}
