package uk.matvey.problems.leet0094;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        var vals = new ArrayList<Integer>();
        var node = root;
        TreeNode pre;
        while (node != null) {
            if (node.left == null) {
                vals.add(node.val);
                node = node.right;
            } else {
                pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node;
                var temp = node;
                node = node.left;
                temp.left = null;
            }
        }
        return vals;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var root = TreeNode.treeNode(1, null, 2, 3);

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly(1, 3, 2);
    }

    @Test
    public void case2() {
        var root = TreeNode.treeNode();

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly();
    }

    @Test
    public void case3() {
        var root = TreeNode.treeNode(1);

        List<Integer> result = new Solution().inorderTraversal(root);

        assertThat(result).containsExactly(1);
    }
}
