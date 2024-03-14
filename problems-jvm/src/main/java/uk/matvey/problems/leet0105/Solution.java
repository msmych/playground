package uk.matvey.problems.leet0105;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TreeNode;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0], rootIndex = -1;
        for (var i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        var nextPreorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        if (rootIndex == -1) {
            return buildTree(nextPreorder, inorder);
        }
        var node = new TreeNode(rootValue);
        node.left = buildTree(nextPreorder, Arrays.copyOf(inorder, rootIndex));
        node.right = buildTree(nextPreorder, Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return node;
    }

}

class SolutionTest {

    @Test
    public void case1() {
        var preorder = new int[]{3, 9, 20, 15, 7};
        var inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode result = new Solution().buildTree(preorder, inorder);

        assertThat(result).isEqualTo(TreeNode.treeNode(3, 9, 20, null, null, 15, 7));
    }
}
