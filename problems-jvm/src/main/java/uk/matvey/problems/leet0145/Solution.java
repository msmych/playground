package uk.matvey.problems.leet0145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
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
                nodes.push(node.val);
                nodes.push(node.right);
                nodes.push(node.left);
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

        var result = new Solution().postorderTraversal(root);

        assertThat(result).containsExactly(3, 2, 1);
    }

    @Test
    void case2() {
        var root = TreeNode.treeNode();

        var result = new Solution().postorderTraversal(root);

        assertThat(result).containsExactly();
    }

    @Test
    void case3() {
        var root = TreeNode.treeNode(1);

        var result = new Solution().postorderTraversal(root);

        assertThat(result).containsExactly(1);
    }

    @Test
    void case4() {
        var root = TreeNode.treeNode(1, 2);

        var result = new Solution().postorderTraversal(root);

        assertThat(result).containsExactly(2, 1);
    }

    @Test
    void case5() {
        var root = TreeNode.treeNode(1, null, 2);

        var result = new Solution().postorderTraversal(root);

        assertThat(result).containsExactly(2, 1);
    }
}