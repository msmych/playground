package uk.matvey.problems.leet0113;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        var paths = new ArrayList<List<Integer>>();
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                paths.add(List.of(root.val));
            }
            return paths;
        }
        for (var leftPath : pathSum(root.left, sum - root.val)) {
            var path = new ArrayList<>(leftPath);
            path.add(0, root.val);
            paths.add(path);
        }
        for (var rightPath : pathSum(root.right, sum - root.val)) {
            var path = new ArrayList<>(rightPath);
            path.add(0, root.val);
            paths.add(path);
        }
        return paths;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);

        List<List<Integer>> result = new Solution().pathSum(root, 22);

        assertThat(result).containsExactly(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
    }
}
