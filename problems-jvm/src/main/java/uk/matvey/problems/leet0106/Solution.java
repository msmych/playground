package uk.matvey.problems.leet0106;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1], rootIndex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        var nextPostorder = Arrays.copyOf(postorder, postorder.length - 1);
        if (rootIndex == -1) {
            return buildTree(inorder, nextPostorder);
        }
        var node = new TreeNode(rootValue);
        node.left = buildTree(Arrays.copyOf(inorder, rootIndex), nextPostorder);
        node.right = buildTree(Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length), nextPostorder);
        return node;
    }

}

class SolutionTest {

    @Test
    public void case1() {
        var inorder = new int[]{9, 3, 15, 20, 7};
        var postorder = new int[]{9, 15, 7, 20, 3};

        TreeNode result = new Solution().buildTree(inorder, postorder);

        assertThat(result).isEqualTo(TreeNode.treeNode(3, 9, 20, null, null, 15, 7));
    }
}
