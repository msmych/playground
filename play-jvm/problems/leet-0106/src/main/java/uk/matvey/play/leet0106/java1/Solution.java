package uk.matvey.play.leet0106.java1;

import uk.matvey.play.types.TreeNode;

import java.util.Arrays;

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
